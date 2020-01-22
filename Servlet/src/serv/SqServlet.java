package serv;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SqServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException, ServletException{
		PrintWriter pw=res.getWriter();
		int k = (int)req.getAttribute("k");
		pw.println("addition is: "+k);
		k= k*k;
		
		pw.println("Square is: "+k);
	}
}

