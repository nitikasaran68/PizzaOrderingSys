// @authors
//Nitika Saran 2014068
//Ishita Verma 2014051
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet(name = "FormServlet", urlPatterns = { "/choose" })
public class Ok extends HttpServlet {
    private static final long serialVersionUID = 54L;
    private static final String TITLE = "Choose user or manager";
 
    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>" + TITLE + "</title></head>");
        writer.println("<body><h1>" + TITLE + "</h1>");
        writer.println("<form method='post'>");
        writer.println("<h1>");
        writer.println("<a href= user>+ user");
        writer.println("<br>");
        writer.println("<a href= manager>+ manager");
        writer.println("</form>");
        writer.println("</body>");
        writer.println("</html>");
    }
 
    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("</body>");
        writer.println("</html>");
    }
}