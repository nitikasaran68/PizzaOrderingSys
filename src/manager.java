// @authors
//Nitika Saran 2014068
//Ishita Verma 2014051

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class manager
 */
@WebServlet("/manager")
public class manager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public manager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		createorder.initfile();
		int len = details.orders.size();
		//Order temp1;
		for (int i = 0; i < len; i++) {
			if(request.getParameter(details.orders.get(i).id)!=null){
				details.orders.get(i).increment();
				updatefile();
			}
		}
		response.setContentType("text/html");
	    PrintWriter writer = response.getWriter();
		writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>" + "</title></head>");
        writer.println("<body><h1>" + "</h1>");
        writer.println("<table border='1'>");
        writer.println("<tr>");
        writer.println("<td>Track ID:</td>");
        writer.println("<td>Name</td>");
        writer.println("<td>Mobile</td>");
        writer.println("<td>Address</td>");
        writer.println("<td>Order</td>");
        writer.println("<td>Status</td>");
       writer.println("</tr>");
		len = details.orders.size();
       Order temp;
		for (int i = 0; i < len; i++) {
			temp= details.orders.get(i);
			writer.println("<tr>");
	        writer.println("<td>" + temp.id +"</td>");
	        writer.println("<td>" + temp.name + "</td>");
	        writer.println("<td>"+ temp.mobile + "</td>");
	        writer.println("<td>" + temp.address +"</td>");
			int l = temp.num;
			writer.println("<td>");
			for (int j = 0; j < l; j++) {
				writer.println(temp.items[j] + "\n");
			}
			writer.println("</td>");
			writer.println("<td>" + temp.status + "</td></tr>");
			writer.println("<td><form action='manager' method='get' > <input type='submit' name='"+temp.id+ "' value = 'Update'></form></td>");
		}
		//writer.println("<a href='user'>Back to User Menu</a>");
		writer.println("<a href='choose'>Back to Main Menu</a>");
        writer.println("</table>");
        writer.println("</body>");
        writer.println("</html>");
	}
	
	void updatefile(){
		try{
			FileWriter out = new FileWriter("/Users/apple/Desktop/workspace/testweb/src/orderlist.txt",false);
			BufferedWriter bu=new BufferedWriter(out);
			int len = details.orders.size();
			Order temp;
			for (int i = 0; i < len; i++) {
				temp= details.orders.get(i);
				bu.write(temp.id + "; ");
				bu.write(temp.name+ "; " + temp.mobile + "; " + temp.address);
				int l = temp.num;
				bu.write("; " + temp.num + "; ");
				for (int j = 0; j < l; j++) {
					bu.write(temp.items[j] + "; ");
				}
				bu.write(temp.status);
				bu.write("\n");
			}
			bu.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		//response.getWriter().println("HELLO");
	}

}
