import java.io.*;
import java.net.*;


public class ChatServer {

	public static void main(String[] args) {
		ServerSocket ss;
		Socket soc;
		InputStream is;
		OutputStream os;
		DataInputStream dis;
		DataOutputStream dos;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try{
			System.out.println("Waiting for clients...");
			ss = new ServerSocket(2000);
			soc= ss.accept();
			System.out.println("Connection Established");
			is=soc.getInputStream();
			os=soc.getOutputStream();
			dis=new DataInputStream(is);
			dos=new DataOutputStream(os);
			while(true)
			{
			System.out.println("Enter Message...");
			String str1=br.readLine();
			dos.writeUTF(str1);
			System.out.println("Client Says: "+dis.readUTF());
			}		
		}catch(Exception ex){
			System.out.println("Error" +ex);
		}
	}
}