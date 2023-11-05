import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
public class login2 extends HttpServlet {  
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{  
        try
        {  
                response.setContentType("text/html");  
                PrintWriter pwriter = response.getWriter();  
                String in_data = request.getParameter("uname");
                pwriter.println("<html><head><style>");
                pwriter.println("body { text-align: center; }");
                pwriter.println("h3 { font-size: 35px; }");
                pwriter.println("p { font-size: 25px; }"); // You can adjust the font size as needed
                pwriter.println("</style></head><body>");        
                pwriter.print("<h3>Hello "+in_data+".</h3>");
                pwriter.println("<br /> <p>Read the special events of the year 2022</p>");
                pwriter.print("<br /> <a href='year_wise_detail.html'>Year-Wise</a>");       
                pwriter.println("</body></html>");
                pwriter.close();
        }
        catch(Exception e){System.out.println(e);}    
} 
}  