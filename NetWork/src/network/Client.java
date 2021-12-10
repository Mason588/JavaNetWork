package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		startClient();

	}
	
	public static void startClient() {
		try 
		{
			Socket socket = new Socket("127.0.0.1",7777);
			DataInputStream fromServer  = new DataInputStream(socket.getInputStream());
			DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
			
			double radius = 5.0;
			toServer.writeDouble(radius);
			double area = fromServer.readDouble();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
