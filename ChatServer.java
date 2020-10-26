package lab4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket server = new ServerSocket(1567);
			System.out.println("Server da duoc tao");
			Socket socket =server.accept();
			System.out.println("Client da ket noi den server");
			//luồng trả kết quả
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			//luồng nhận dl
			DataInputStream in = new DataInputStream(socket.getInputStream());
			Scanner input = new Scanner(System.in);
			while(true) {
				//Doc dl tu client
				String str =in.readUTF();
				if(str.equalsIgnoreCase("q")) {	
					break;
				}else {
					System.out.println("Client: " + str);
				}
				// gui dl sang client
				System.out.println("\n");
				out.writeUTF(input.nextLine());
				out.flush();
			}
			System.out.println("Cuoc tro chuyen ket thuc");
			input.close();
			in.close();
			out.close();
			socket.close();
			server.close();
		} catch (IOException e) {
			System.out.println("Cuoc tro chuyen ket thuc");
		}

	}

}