package ChartRoom;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	private Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private ClientThread t;
	private ClientGui gui;
	private String name;
	
	public Client(String name, ClientGui gui){
		this.name = name;
		this.gui = gui;
	}
	
	public String getName(){
		return this.name;
	}
	
	protected boolean connect(String host, int port){
		//connect to the server
		System.out.println("connecting");
		try{		
			socket = new Socket(host, port);	
			out =new ObjectOutputStream(socket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(socket.getInputStream());
			//System.out.println("connected");
			
		} catch (UnknownHostException e1) {
			System.err.println("Don't know about host: "+host);
			return false;
		} catch (IOException e2) {
			System.err.println("Couldn't get I/O for "+"the connection to: "+host);
			return false;
		}
		
		if (socket.isConnected())
			System.out.println(socket.getPort()+", "+socket.getLocalPort());
		
		t = new ClientThread(in, gui);
		t.start();	
		return true;
	}
	
	protected void sendMessage(Message msg){
		try {
			out.writeObject(msg);
			//out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	protected void disconnect(){	
		try {
			in.close();
			out.close();
			socket.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
