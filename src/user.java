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

@WebServlet("/user")
public class user extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public user() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>" + "user"+ "</title></head>");
        writer.println("<body>");
        writer.println("<h1>");
        writer.println("<a href=createorder>+ Create new order</a><br>" );
        writer.println("<a href='trackorder'>Track an order</a>");
        writer.println("</form>");
        writer.println("</body>");
        writer.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
