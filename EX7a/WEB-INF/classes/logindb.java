import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class logindb extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html");
        Connection conn=null;
        Statement stmt=null;
        PrintWriter out = response.getWriter();
        String username = request.getParameter("uname");
        String password = request.getParameter("password");
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/events","root", "");
            stmt = conn.createStatement();
            String sql = "SELECT * FROM login_check WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
              out.println("<html><head><style>");
              out.println("body { text-align: center; }");
              out.println("h3 { font-size: 35px; }");
              out.println("p { font-size: 25px; }"); 
              out.println("</style></head><body>");
              out.print("<h3>Welcome back " + username + "</h3>");
              out.println("<br /> <p>Login Successful!</p>");
        
        out.println("</body></html>");
          } else {
              out.println("<html><body>");
              out.println("<h1>Login Failed</h1>");
              out.println("</body></html>");
          }
          rs.close();
          pstmt.close();
          conn.close();
        }
        catch(Exception e)
        {
            System.out.print("Do not connect to DB - Error:"+e);
        }
    }
}