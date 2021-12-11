package network;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class StudentClient {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost",8000);
			
			//接收資料
			ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());
			
			StudentAddress student = new StudentAddress("Andrew", "US", "New York", "good",
					"24564");
			
			toServer.writeObject(student);
		} catch(IOException e) {
		}

	}

}
