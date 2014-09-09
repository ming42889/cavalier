package lectureEx.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.Pipe;
import java.nio.channels.ServerSocketChannel;
import java.util.LinkedList;
import java.util.Queue;

public class Server {
	private Queue<ServerThread> tq = new LinkedList<ServerThread>();
	private ServerSocket listenfd;
	private Socket connfd;
	private BufferedReader in;
	private PrintWriter out;
	private boolean isClosing;
	private int uid;
	private ServerSocketChannel ssc;

	public Server(int port){
		this.isClosing=false;
		this.uid = 1;
		try {
			this.ssc = ServerSocketChannel.open();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try{
			this.listenfd = new ServerSocket(port);
			System.out.println("listening on port: "+this.listenfd.getLocalPort());
		} catch (IOException e){
			System.out.println("Could not listen on port: 8001");
			System.exit(-1);
		}
	}

	public void run(){

		try{
			/*	after accepting a connection create a new listening sock
			 * 	and send its port number to the client, then hand overall
			 *  the communication with this client to a child thread  
			 */	
			connfd = listenfd.accept();	
			ServerThread st = new ServerThread(uid++, tq, new ServerSocket(0));
			
			out = new PrintWriter(new OutputStreamWriter(connfd.getOutputStream()));
			out.println(st.getLocalPort());
			out.flush();
			
			tq.add(st);
			st.start();
			st = null;
			out.close();
			connfd.close();

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
			listenfd.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Server closed");
	}


	public static void main(String args[]){

		Server server = new Server(8001);

		while (!server.isClosing){
			server.run();
		}

		server.close();

	}


}
