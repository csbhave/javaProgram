import java.sql.*;
import java.io.*;

class JdbcProg1
{
	public static void main(String args[]) throws IOException
	{
		Connection c;
		Statement s;
		ResultSet rs;
		String sql;
		int cnt=0;
		try
		{
			System.out.println("============================");
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Drivers Loaded Successfully");
			System.out.println("============================");
			c=DriverManager.getConnection("jdbc:odbc:DSN");
			System.out.println("Connection Done Successfully");
			System.out.println("============================");
			s=c.createStatement();
			sql="select * from Employee";
			rs=s.executeQuery(sql);
			
			while(rs.next())
			{
				cnt++;
				System.out.println("\nNo Of Record: "+cnt);
				System.out.println("=================================================");
				System.out.println("\tPid :" +rs.getString(1)+ "\tname :" +rs.getString(2)+"\tsalary :" +rs.getString(4));	
				System.out.println("=================================================");
				
			}
			c.close();
		}catch(ClassNotFoundException e){System.out.println("Error: unable to load driver class!" +e);}
			catch(SQLException e){System.out.println("Error: access problem while loading!" +e );}
		
	}
}