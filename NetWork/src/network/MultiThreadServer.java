package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.InetAddress;
import java.net.ServerSocket;

public class MultiThreadServer {
	 private int clientNu = 0;
	 
	 public void start() {
		 new Thread(() ->{
			 try {
				 
				 ServerSocket serversocket = new ServerSocket(8787);
				 
				 while(true) {
					 Socket socket = serversocket.accept();
					 
					 clientNu++;
					 System.out.println("連接客戶編號:" +clientNu);
					 
					 //尋找client的ip,hostName,跟地址
					 InetAddress inetAddress = socket.getInetAddress();
					 System.out.println(inetAddress.getHostAddress());
					 System.out.println(inetAddress.getHostName());
					 
					 //創造跟開始一個新執行緒
					 new Thread(new HandleAClient(socket)).start();
				 }
			 } catch(IOException ex) {
				 ex.printStackTrace();
			 }
		 }).start();
	 }
		 
	public static void main(String[] args) {
		new  MultiThreadServer().start();
	}
	
	

}

class HandleAClient implements Runnable{

	private Socket socket;
	
	public HandleAClient(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		try {
			
			DataInputStream input = new DataInputStream(
					socket.getInputStream());
			DataOutputStream output = new DataOutputStream(
					socket.getOutputStream());
			
			while(true) 
			{
				double radius = input.readDouble();
				double area = radius * radius * Math.PI;
				output.writeDouble(area);
			}
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}