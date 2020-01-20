import java.net.*;
import java.io.*;
public class Client
{
	public static void main(String ar[])throws IOException
	{
		try{
			System.out.println("Client Started...");
			Socket soc = new Socket("localhost",2000);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("enter a string...");
			String str= br.readLine();
			PrintWriter pw= new PrintWriter(soc.getOutputStream(),true);
			pw.println(str);
			BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			System.out.println(in.readLine());
		}catch(Exception ex){
			System.out.println("Error "+ex);
		}
		}
	}
		