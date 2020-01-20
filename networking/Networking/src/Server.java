import java.io.*;
import java.net.*;

class Server
{
	public static void main(String arr[])throws IOException
	{
		try{
		System.out.println("Waiting for clients...");
		ServerSocket ss = new ServerSocket(2000);
		Socket soc= ss.accept();
		System.out.println("Connection Established");
		BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
		String str= in.readLine();
		PrintWriter pw=new PrintWriter(soc.getOutputStream(),true);
		pw.println("Server says:\t "+str);
		
		}catch(Exception ex){
			System.out.println("Error" +ex);
				
		}
		}
	}
