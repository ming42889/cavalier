package lectureEx.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Queue;

public class ServerThread extends Thread{
	private ServerSocket listenfd;
	private BufferedReader in;
	private PrintWriter out;
	private Socket connfd;
	private int uid;
	private Queue<ServerThread> q;
	
	public ServerThread(int uid, Queue<ServerThread> tq, ServerSocket ss){
		this.uid = uid;
		this.listenfd = ss;
		this.q = tq;
	}
	
	public int getLocalPort(){
		return listenfd.getLocalPort();
	}
	
	public int getUid(){
		return uid;
	}
	
	public void write(String mesg){
		out.println(mesg);
		out.flush();
	}
	
	public void run(){
		
		try {
			connfd = listenfd.accept();
			in = new BufferedReader(new InputStreamReader(connfd.getInputStream()));
			out = new PrintWriter(new OutputStreamWriter(connfd.getOutputStream()));
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		String s;
		try {
			while( (s = uid+": "+in.readLine())!=null){
				for(ServerThread st: q) st.write(s);
				
				/*
				out.println(s);
				out.flush();
				System.out.println(s);*/
			}
		} catch (IOException e1) {
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
			listenfd.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	


}
