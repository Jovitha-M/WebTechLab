import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class passworddb extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Connection conn=null;
        PrintWriter out = response.getWriter();
        String username = request.getParameter("name");
        String current_password = request.getParameter("current");
        String new_password = request.getParameter("new");
        out.println("<html><head><style>");
        out.println("body { text-align: center; }");
        out.println("h3 { font-size: 35px; }");
        out.println("p { font-size: 25px; }"); 
        out.println("</style></head><body>");
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/events","root", "");
            String sql = "UPDATE signup_check SET password = ? WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, new_password);
            stmt.setString(2, username);
            stmt.setString(3, current_password);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                out.println("<br><br><br><h3><center>Password changed successfully</center></h3>");
            } else {
                out.println("<br><br><br><h3><center>Failed to change password</center></h3>");
            }
            out.println("</body></html>");
            stmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}