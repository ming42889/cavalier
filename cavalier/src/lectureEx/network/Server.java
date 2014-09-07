package lectureEx.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Server {
	private LinkedList<ServerThread> tq = new LinkedList<ServerThread>();
	private ServerSocket sock;
	private Socket recSocket;
	private BufferedReader in;
	private PrintWriter out;
	private boolean isClosing;
	
	private Socket new_sock;

	public Server(int port){
		this.isClosing=false;
		try{
			this.sock = new ServerSocket(port);
			System.out.println("listening on port: "+this.sock.getLocalPort());
		} catch (IOException e){
			System.out.println("Could not listen on port: 8001");
			System.exit(-1);
		}
	}

	public void run(){

		try{
			recSocket = sock.accept();
			out = new PrintWriter(new OutputStreamWriter(recSocket.getOutputStream()));
			new_sock = new Socket();
			new_sock.bind(null);
			out.println(new_sock.getLocalPort());
			System.out.println(new_sock.getLocalPort());
			System.out.println("client accepted at host = "+recSocket.getInetAddress()+" use new socket on port: "
					+recSocket.getPort()+" for further communication");
			ServerThread child = new ServerThread(recSocket.getInetAddress(), recSocket.getPort());
			tq.add(child);
			child.start();
			//System.out.println("local: "+recSocket.getLocalPort()+", remote: "+recSocket.getPort());

		} catch (IOException e) {
			System.out.println("Accept failed: 8001");
			System.exit(-1);
		}
	}

	public void close(){
		for(ServerThread t: tq){
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		try {
			sock.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void main(String args[]){

		Server server = new Server(8001);

		while (!server.isClosing){
			server.run();
		}

		server.close();

	}


}
