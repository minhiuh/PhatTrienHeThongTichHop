package IPAddress;

import java.net.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class TimDCIP {
	public static void main(String[] args) {
		try{
			if(args.length!=1)  
				{
				System.out.println("Cach su dung: java TimDCIP <Hostname>");
				}
			InetAddress host = InetAddress.getByName("www.google.com");
			String hostName = host.getHostName();
			System.out.println("Host name:"+hostName);
			System.out.println("Dia chi IP:"+host.getHostAddress());
			}
			catch(UnknownHostException e)
			{
			System.out.println("Khong tim thay dia chi");
			return;
			}

	}

}
