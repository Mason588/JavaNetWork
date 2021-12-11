package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		startClient();

	}
	
	public static void startClient() {
		try 
		{
			Socket socket = new Socket("127.0.0.1",8787);
			DataInputStream fromServer  = new DataInputStream(socket.getInputStream());
			DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
			
			
			//循環讀取
			while(true)
			{		
				//用Scanner讀取用戶輸入
				Scanner scan = new Scanner(System.in);
				double radius = scan.nextDouble();
				
				toServer.writeDouble(radius);
				double area = fromServer.readDouble();
				System.out.println("Area is : " +area);
			    System.out.println(socket.getLocalPort());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
