package socket;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * 服务器线程处理类
 */
public class ServerThread extends Thread {
	// 和本线程相关的Socket
	Socket socket = null;

	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	
	public void run(){
		InputStream is=null;
		InputStreamReader isr=null;
		BufferedReader br=null;
		OutputStream os=null;
		PrintWriter pw=null;
		try {
			is= socket.getInputStream();
			isr=new InputStreamReader(is);
			br=new BufferedReader(isr);
			String info=null;
			String res = null;
			os = socket.getOutputStream();
			pw = new PrintWriter(os);
			int result=0;
			while(true) {
			if(br.readLine()!=null) {	
			info=br.readLine();
				 res=info;
				for(int i=0;i<info.length()-1;i++) {
					if(info.substring(i,i+1).equals("+")) {
						result=Integer.parseInt((info.substring(0, i)).trim())+Integer.parseInt((info.substring(i+1, info.length())).trim());
					}
				}
//			socket.shutdownInput();
			
			pw.write(res+" = "+result);
			pw.flush();
			}
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(pw!=null)
					pw.close();
				if(os!=null)
					os.close();
				if(br!=null)
					br.close();
				if(isr!=null)
					isr.close();
				if(is!=null)
					is.close();
				if(socket!=null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
