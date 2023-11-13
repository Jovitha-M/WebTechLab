import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class contact extends HttpServlet {
   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Thank you for contacting us! We'll be reaching you soon";
      String docType ="<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";   
      out.println(docType +
         "<html>\n" +
            "<head><title>" + title + "</title></head>\n" +
            "<body style=\"background-color: hsla(221, 73%, 63%, 0.82);\">\n" + // Set background color
               "<h1 align = \"center\">" + title + "</h1>\n" +
               "<ul>\n" +
                  "  <li><b>Name</b>: "
                  + request.getParameter("name") + "\n" +
                  "  <li><b>Email</b>: "
                  + request.getParameter("email") + "\n" +
                  "  <li><b>City</b>: "
                  + request.getParameter("city") + "\n" +
                  "  <li><b>Mobile</b>: "
                  + request.getParameter("mobile") + "\n" +
                  "  <li><b>Message</b>: "
                  + request.getParameter("message") + "\n" +
               "</ul>\n" +
            "</body>" +
         "</html>"
      );
   }
}
