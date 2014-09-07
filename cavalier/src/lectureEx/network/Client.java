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
		String request;
		String host = "LocalHost";
		int port = 8001;
		
		try{
			socket = new Socket(host, port);
			System.out.println("local: "+socket.getLocalPort()+", remote: "+socket.getPort());
			out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			port = Integer.parseInt(in.readLine()); // a blocking read
			System.out.println("reconnect to port: "+port);
			
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host: seattle.");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for "+"the connection to: seattle.");
			System.exit(1);
		}
		
		/*
		System.out.println("Server says:"+in.readLine());
		System.out.print("Client can Request for Date or Quit:");
		Scanner sc = new Scanner(System.in);
		request = sc.nextLine();
		out.println(request);
		out.flush();
		System.out.println("Server responds:"+in.readLine());
		sc.close();
		*/
		in.close();
		out.close();
		socket.close();
		
	}
}
