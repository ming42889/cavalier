package lectureEx.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateServer {
	public static void main(String args[]){
		ServerSocket server = null;
		Socket recSocket = null;
		PrintWriter ou = null;
		BufferedReader i = null;
		String mesg;
		
		
		try{
			server = new ServerSocket(8001);
		} catch (IOException e){
			System.out.println("Could not listen on port: 8001");
			System.exit(-1);
		}
		while (true) {
		System.out.println("listening for client");
		try{
			recSocket = server.accept();
		} catch (IOException e) {
			System.out.println("Accept failed: 8001");
			System.exit(-1);
		}
		System.out.println("client accepted");
		
		
		try {
			i = new BufferedReader(new InputStreamReader(recSocket.getInputStream()));
			ou = new PrintWriter(new OutputStreamWriter(recSocket.getOutputStream()));
			ou.println(server);
			ou.flush();
			mesg=i.readLine();
			if(mesg.equals("Date")){
				System.out.println("a request on date");
				mesg = "Client asked for"+mesg+" and the Current date is "+(new Date()).toString();
				ou.println(mesg);
				ou.flush();
			} else {
				if (mesg.equals("Quit"))
					System.exit(1);
				else {
					mesg = "invalid request";
					ou.println(mesg);
					ou.flush();
					i.close();
					ou.close();
					recSocket.close();
				}
					
				
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("failed to read mesg from client: 8001");
			System.exit(-1);
		}
		}
	}
}
