package lab4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket socket = new Socket("localhost",1567);
			//luồng trả kết quả
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			//luồng nhận dl
			DataInputStream in = new DataInputStream(socket.getInputStream());
			Scanner input = new Scanner(System.in);
			while(true) {
				//gui dl sang server
				System.out.println("\nI: ");
				out.writeUTF(input.nextLine());
				out.flush();
				// doc dl tu server
				String str =in.readUTF();
				if(str.equalsIgnoreCase("q")) {	
					break;
				}else {
					System.out.println("Server: " + str);
				}
				
			}
			System.out.println("Cuoc tro chuyen ket thuc");
			input.close();
			in.close();
			out.close();
			socket.close();
		} catch (IOException e) {
			System.out.println("Cuoc tro chuyen ket thuc");
		}
	}

}