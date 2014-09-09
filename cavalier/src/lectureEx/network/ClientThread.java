package lectureEx.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThread extends Thread{
	private BufferedReader in;
	private Socket sock;
	
	public ClientThread(Socket sock){
		this.sock = sock;
	}
	

	
	public void run(){
		try {
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			
			while(true){
				System.out.println(in.readLine());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	


}
