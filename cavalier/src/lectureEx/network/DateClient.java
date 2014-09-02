package lectureEx.network;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class DateClient {
	public static void main(String args[]) throws IOException {
		Socket socket = null;
		BufferedReader in = null;
		PrintWriter out = null;
		String request;
		try{
			socket = new Socket("LocalHost", 8001);
			out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host: seattle.");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for "+"the connection to: seattle.");
			System.exit(1);
		}
		
		System.out.println("Server says:"+in.readLine());
		System.out.print("Client can Request for Date or Quit:");
		Scanner sc = new Scanner(System.in);
		request = sc.nextLine();
		out.println(request);
		out.flush();
		System.out.println("Server responds:"+in.readLine());
		in.close();
		out.close();
		socket.close();
	}
}
