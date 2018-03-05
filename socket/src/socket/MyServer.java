package socket;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class MyServer {

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket=new ServerSocket(9999);
			Socket socket=null;
			int Clientsnum=0;
			System.out.println("***The server is started, waiting for the client's connection ***");
			while(true){
				socket=serverSocket.accept();
				ServerThread serverThread=new ServerThread(socket);
				serverThread.start();				
				Clientsnum++;
				System.out.println("Count of clients"+Clientsnum);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
