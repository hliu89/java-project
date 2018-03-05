package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client1 {

	public static void main(String[] args) {
		
		try {
			
			Socket socket=new Socket("localhost", 9999);
			Scanner sc=new Scanner(System.in);
			BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw=new PrintWriter(socket.getOutputStream());
			String info=null;
			while(true) {
			
			
			System.out.println("Client,please input message:");
			String message=sc.next();
			
			
			pw.write(message);
			pw.flush();
     		//socket.shutdownOutput();
			
			info=br.readLine();
				System.out.println("Myserver:"+info);
			if(message=="exit") {
				socket.shutdownOutput();
				break;
			}
		}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
