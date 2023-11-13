import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class login1 extends HttpServlet {
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     try {
        response.setContentType("text/html");
        PrintWriter pwriter = response.getWriter();
        String in_data = request.getParameter("uname");
        Cookie c = new Cookie("Ucookie", in_data);
        response.addCookie(c);
        pwriter.println("<html><head><style>");
        pwriter.println("body { text-align: center; }");
        pwriter.println("h3 { font-size: 35px; }");
        pwriter.println("p { font-size: 25px; }"); 
        pwriter.println("</style></head><body>");        
        pwriter.print("<h3>Welcome back " + in_data + "</h3>");
        pwriter.println("<br /> <p>Login Successful!</p>");
        pwriter.print("<form action='logincookie2' method='POST'>");  
        pwriter.print("<input type='hidden' name='uname' value='"+in_data+"'>");  
        pwriter.print("<input type='submit' value='Start reading'>");
        pwriter.println("</body></html>");  
        pwriter.print("</form>");       
        pwriter.close();
    } catch(Exception exp) {
       System.out.println(exp);
    }
  }
}
