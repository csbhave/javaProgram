package add;

import java.util.Scanner;

public class Operation {

	public static void main(String[] args) {
		
		int a,b,res;
		String op;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter 1 no");
		a= sc.nextInt();
		System.out.println("Enter operator");
		op= sc.next();
		System.out.println("Enter 2 nd");
		b= sc.nextInt();
	
		if(op.equals("+")) {
			res=a + b;
			System.out.println(res);
		}
		else 
		System.out.println("invaild operation");
	
	}
}
