import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class login extends HttpServlet {
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
        try{
            response.setContentType("text/html");
            PrintWriter out= response.getWriter();
            out.println("<center><br><br>");
            out.println("<h1>Login Successful</h1></center>");
        }
        catch(Exception e){
            System.out.print(e);
        }
    }
}