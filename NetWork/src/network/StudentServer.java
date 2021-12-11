package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class StudentServer {
	ObjectInputStream fromClient;
	public StudentServer() 
	{
		try {
			ServerSocket serverSocket = new ServerSocket(8000);
			System.out.println("伺服器啟動...");
			
				//循環監聽
				while(true) 
				{
					Socket socket = serverSocket.accept();
					
					fromClient = new ObjectInputStream(socket.getInputStream());
					Object obj = fromClient.readObject();
					System.out.println(obj);
				}
			} catch(IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
			} finally {
				try {
					fromClient.close();
			} catch(IOException ee) {
				ee.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new StudentServer();
	}
}
