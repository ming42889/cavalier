package lectureEx.network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Queue;

public class ServerThread extends Thread{
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private Socket connfd;
	private Queue<ServerThread> q;
	
	public ServerThread(Queue<ServerThread> tq, Socket connfd){
		this.connfd = connfd;
		this.q = tq;
	}
	
	public int getLocalPort(){
		return connfd.getLocalPort();
	}
	
	
	public void write(Message msg){
		try {
			out.writeObject(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run(){	
		
		try {
			out =new ObjectOutputStream(connfd.getOutputStream());
			out.flush();
			in = new ObjectInputStream(connfd.getInputStream());	
		} catch (IOException e1) {
			System.err.println("error when initializing I/O streams");
			if (e1 instanceof SocketException){
				System.out.println("SocketException");
			}else e1.printStackTrace();
		}
			
		//broadcasting
		Message msg;
		try {
			while( (msg = (Message) in.readObject())!=null){
				if (msg.getType()!=Message.LOGOUT)
					for(ServerThread st: q) st.write(msg);
				else break;
			}
		} catch (IOException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			if (e1 instanceof SocketException){
				System.out.println("SocketException");
			} else e1.printStackTrace();
		}
		
		
		//closing
		try {
			in.close();
			out.close();
			connfd.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	


}
