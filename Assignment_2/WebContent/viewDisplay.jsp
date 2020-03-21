<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>View Student Details</h1>
<%
	String id = request.getParameter("id");

	try{
		Class.forName("com.mysql.Jdbc.Driver");
		Connection c = DriverManager.getConnection("Jdbc:mysql://localhost:3306/placement","root","");
		Statement st= c.createStatement();
		ResultSet rs= st.executeQuery("select * from student where id='+id+'");
		
		while(rs.next()){%>
				<tr>
					<td>Student details</td>
				</tr>
				<tr>
					<td><% rs.getInt(1) %></td>
					<td><% rs.getString(2) %></td>
					<td><% rs.getString(3) %></td>
					<td><% rs.getString(4) %></td>
					<td><% rs.getString(5) %></td>	
				</tr>
						
			<% 
		}
	}catch(Exception e){
		out.println("Error Occur"+e); 
	}

%>
</body>
</html>