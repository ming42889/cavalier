package lectureEx.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String args[]) throws IOException {
		Socket socket = null;
		BufferedReader in = null;
		PrintWriter out = null;
		String line;
		String host = "LocalHost";
		int port = 8001;
		
		//connect to the server
		try{		
			socket = new Socket(host, port);	
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host: "+host);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for "+"the connection to: "+host);
			System.exit(1);
		}
		
		
		System.out.println("local: "+socket.getLocalPort()+", remote: "+socket.getPort());
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		port = Integer.parseInt(in.readLine()); // a blocking read
		System.out.println("reconnect to port: "+port);
		in.close();
		
		//reconnect to a new port
		try{		
			socket = new Socket(host, port);	
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host: "+host);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for "+"the connection to: "+host);
			System.exit(1);
		}
		
		ClientThread t = new ClientThread(socket);
		t.start();
		
		out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		Scanner sc = new Scanner(System.in);
		line="";
		while(line!="quit"){
			line = sc.nextLine();
			out.println(line);
			out.flush();
		}

		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
		out.close();
		socket.close();
		
	}
}
