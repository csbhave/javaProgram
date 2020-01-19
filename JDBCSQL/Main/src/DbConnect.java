import java.sql.*;
import java.io.*;
public class DbConnect {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public DbConnect(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost/jdbc_test","root","");
			System.out.println("Database connected");
			st=con.createStatement();
		
		}catch(Exception ex){
			System.out.println("Error "+ex);
		}
	}
	public void ShowData(){
		try{
			String qry="select * from student";
			rs= st.executeQuery(qry);
			System.out.println("Fetch records from database");
			while(rs.next()){
				String id= rs.getString("id");
				String name= rs.getString("name");
				String phno= rs.getString("phno");
				String email= rs.getString("email");
				
				System.out.println("\tID:"+id+"\tName:"+name+"\tPhoneNo:"+phno+"\tEmailID:"+email);
						
			}
		
		}catch(Exception ex){
		System.out.println("Error "+ex);
		}
	}
	public void Insert(){
		try{
			System.out.println("Insert Appropriate Data...");
			System.out.println("Enter your ID:\t");
			String id= br.readLine();
			System.out.println("Enter your Name:\t");
			String name= br.readLine();
			System.out.println("Enter your phoneNo:\t");
			String phno= br.readLine();
			System.out.println("Enter your EmailID:\t");
			String email= br.readLine();
			st=con.createStatement();
			String qry="INSERT INTO student (id, name, phno, email) "
			          + "VALUES ('"+id+" ','"+name+"','"+phno+"','"+email+"')"; 
			st.executeUpdate(qry);
			System.out.println("Record inserted successfully");
			System.out.println("\tID:"+id+"\tName:"+name+"\tPhoneNo:"+phno+"\tEmailID:"+email);
			
		}catch(Exception ex){
			System.out.println("Error "+ex);
		}
	}
	public void Update(){
		try{
            System.out.println("Enter student Number for the record you wish to Update: ");
            String id= br.readLine();
            System.out.println("Enter Your Name:\t");
            String name=br.readLine();
            System.out.println("Enter Your PhoneNo:\t");
            String phno=br.readLine();
            System.out.println("Enter Your EmailID:\t");
            String email=br.readLine();
            
           String qry = "UPDATE student " +
            "SET name='"+ name +"', phno='"+phno+"', email='"+email+"' WHERE id ='"+id+"' ";
           		st.executeUpdate(qry);
           		System.out.println("Record Updated successfully");
           		System.out.println("\tID:"+id+"\tName:"+name+"\tPhoneNo:"+phno+"\tEmailID:"+email);
    				
		}catch(Exception ex){
			System.out.println("Error "+ex);
		}
	}
	public void Delete(){
		try{
			 System.out.println("Enter student Number for the record you wish to Delete: ");
	           String id= br.readLine();
	           
	           String sql = "DELETE FROM student " +
	                   "WHERE id = '"+id+"'";
	      st.executeUpdate(sql);      
	      System.out.println("Record deleted Successfully");
		}catch(Exception ex){
			System.out.println("Error "+ex);
		}
	}
}