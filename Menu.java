import java.io.*;
import java.sql.*;

class Operation
{
    public void Menu()
    {
        System.out.println("\n===Menu===");
        System.out.println("\n1. Insert");
        System.out.println("\n2. Update");
        System.out.println("\n3. Delete");
        System.out.println("\n4. Show table");
        System.out.println("\n5. Exit");
      
    }
    public void Insert()
    {
        System.out.println("Insert data into database...");
       //sql="select * from Employee";
    }
    public void Update()
    {
        System.out.println("update database...");
    }
    public void Delete()
    {
        System.out.println("Delete Record from database...");
    }
    public void Showtable()
    {
        int cnt=0;
        System.out.println("Show table");
        String sql="select * from Employee";
        
        while(rs.next())
        {
            cnt++;
            System.out.println("\nNo Of Record: "+cnt);
            System.out.println("=================================================");
            System.out.println("\tPid :" +rs.getString(1)+ "\tname :" +rs.getString(2)+"\tsalary :" +rs.getString(4));	
            System.out.println("=================================================");
            
        }

    }

}

public class Menu extends Operation
{
    public void Showtable()
    {
        int cnt=0;
        System.out.println("Show table");
        String sql="select * from Employee";
        
        while(rs.next())
        {
            cnt++;
            System.out.println("\nNo Of Record: "+cnt);
            System.out.println("=================================================");
            System.out.println("\tPid :" +rs.getString(1)+ "\tname :" +rs.getString(2)+"\tsalary :" +rs.getString(4));	
            System.out.println("=================================================");
            
        }

    }

    public static void main(String args[])throws IOException
    {
        int ch;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            System.out.println("========================================");
            System.out.println("Configure JDBC Connection...");
            Connection c;
            Statement s;
            System.out.println("============================");
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            System.out.println("Drivers Loaded Successfully");
            System.out.println("============================");
            c=DriverManager.getConnection("jdbc:odbc:DSN");
            ResultSet rs=s.executeQuery(sql);
            Menu m=new Menu();
            m.Menu();
            System.out.println("\nChoose Your Choice: ");
            ch = Integer.parseInt(br.readLine());
            System.out.println("\nYour Choice: "+ch);            

            while(ch!=0)
            {
                Operation op = new Operation();
                switch(ch)
                {
                    case 1: 
                            op.Insert();
                            System.exit(0);
                    case 2: op.Update();
                            System.exit(0);
                    case 3: op.Delete();
                            System.exit(0);
                    case 4: Menu me=new Menu();
                            m.Showtable();
                            System.exit(0);
                    case 5: System.exit(0);
                    default: System.out.println("Please Select Valid Option...");
                            System.exit(0);
                }
            }
           
    c.close();
    }catch(ClassNotFoundException e){System.out.println("Error: unable to load driver class!" +e);}
    catch(SQLException e){System.out.println("Error: access problem while loading!" +e );}

    }
    
}