package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		startServer();
	}

	public  static void  startServer() {
		try {
			ServerSocket serverSocket = new ServerSocket(1234);
			Socket socket = serverSocket.accept();
			
			DataInputStream in  = new DataInputStream(socket.getInputStream());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			
			while(true) 
			{
				double radius = in.readDouble();
				double area = radius * radius * Math.PI;
				
				out.writeDouble(area);
				System.out.println("Area is :" + area + "and already to sent to client!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
