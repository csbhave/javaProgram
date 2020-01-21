import java.io.*;
public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		DbConnect connect = new DbConnect();
		System.out.println("\nMenu");
		do {
		System.out.println("\n1.Insert data");
		System.out.println("\n2.Update data");
		System.out.println("\n3.Delete data");
		System.out.println("\n4.Show Table");
		System.out.println("\n5	.Exit");
		System.out.println("\nEnter Your Choice: ");
		int ch = Integer.parseInt(br.readLine());
		switch(ch){
			case 1:
					connect.Insert();
					break;
			case 2: connect.Update();
					break;
			case 3: connect.Delete();
					break;		
			case 4: connect.ShowData();
					break;
			case 5: System.exit(0);
			

			default: System.out.println("Please Enter Valid Choice...");
			}
	
		}while(true);
			
	}

}
