package ChartRoom;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;

public class Server {
	private Queue<ServerThread> tq = new LinkedList<ServerThread>();
	private ServerSocket listenfd;
	private Socket connfd;

	private boolean isClosing;


	public Server(int port){
		this.isClosing=false;
		
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
			ServerThread st = new ServerThread(tq, connfd);

			tq.add(st);
			st.start();
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
