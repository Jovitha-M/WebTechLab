import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
public class login2 extends HttpServlet {  
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{  
        try
        {  
                response.setContentType("text/html");  
                PrintWriter pwriter = response.getWriter();  
                pwriter.println("<html><head><style>");
                pwriter.println("body { text-align: center; }");
                pwriter.println("h3 { font-size: 35px; }");
                pwriter.println("p { font-size: 25px; }"); 
                pwriter.println("</style></head><body>");        
                HttpSession session=request.getSession(false);  
                String n=(String)session.getAttribute("login_name");  
                pwriter.print("<h3>Hello "+n+".</h3>");
                pwriter.println("<br /> <p>Read the Year wise special events</p>");
                pwriter.print("<br /> <a href='year_wise_details.html'>Year-Wise</a>");       
                pwriter.println("</body></html>");
                pwriter.close();
        }
        catch(Exception e){System.out.println(e);}    
} 
}  