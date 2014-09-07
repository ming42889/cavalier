package lectureEx.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServerThread extends Thread{
	private int client_port;
	private InetAddress client_host;
	private Socket sock;
	private BufferedReader in;
	private PrintWriter out;
	
	public ServerThread(InetAddress client_host, int client_port){
		this.client_host = client_host;
		this.client_port = client_port;
	}
	
	public void run(){
		
		try {
			sock = new Socket();
			out = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
			//in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out.println(sock.getLocalPort());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(client_port);
	}

}
