package ChartRoom;

import java.io.IOException;
import java.io.ObjectInputStream;


public class ClientThread extends Thread{
	private ObjectInputStream in;
	private ClientGui gui;
	
	public ClientThread(ObjectInputStream in, ClientGui gui){
		this.in = in;
		this.gui = gui;
	}
	
	public void run(){
		Message msg;
		
		try {
			while((msg=(Message) in.readObject())!=null){
				gui.append(msg.getContent()+"\n");
			}
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			gui.append("connection lost\n");
			gui.connectionFailed();
		}
	}
}
