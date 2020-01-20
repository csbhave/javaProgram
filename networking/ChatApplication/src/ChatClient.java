import java.io.*;
import java.net.*;


public class ChatClient {

	public static void main(String[] args) {
		Socket soc;
		InputStream is;
		OutputStream os;
		DataInputStream dis;
		DataOutputStream dos;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try{
			System.out.println("Client Started...");
			soc = new Socket("localhost",2000);
			is=soc.getInputStream();
			os=soc.getOutputStream();
			dis=new DataInputStream(is);
			dos=new DataOutputStream(os);
			while(true)
			{
				System.out.println("Server Says: "+dis.readUTF());
				System.out.println("Enter Reply");
				String str1=br.readLine();
				dos.writeUTF(str1);
			}
		
		}catch(Exception ex){
			System.out.println("Error" +ex);
		
		}
	}
}