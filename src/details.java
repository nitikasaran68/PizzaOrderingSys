// @authors
//Nitika Saran 2014068
//Ishita Verma 2014051

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class details
 */
@WebServlet("/details")
public class details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       static ArrayList<Order> orders;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public details() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("loaded");
		response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>" + "details"+ "</title></head>");
        writer.println("<body>");
        writer.println("* denotes mandatory fields");
        writer.println("<h3>");
		writer.println("<form action='details' method = \"post\">");
		writer.println("please enter your details");
		writer.println("<p>");
		writer.println("Name*: <input type='text' name='username' value=''>");
		writer.println("<p>");
		writer.println("Contact Number*: <input type='text' name='contact' value=''>");
		writer.println("<p>");
		writer.println("Address*: <input type='text' name='address' value=''>");
		writer.println("<p>");
		writer.println("<input type='submit' value='Submit'>");
		writer.println("</form>");
		writer.println("<p>");
		writer.println("<a href='user'>Back to User Menu</a>");
		writer.println("<a href='choose'>Back to Main Menu</a>");
		writer.println("</body>");
		writer.println("</html>");
	}

	
	void file(){
		try{
			FileWriter out = new FileWriter("/Users/apple/Desktop/workspace/testweb/src/orderlist.txt",true);
			BufferedWriter bu=new BufferedWriter(out);
			bu.write(createorder.current.id + "; ");
			bu.write(createorder.current.name + "; " + createorder.current.mobile + "; " + createorder.current.address);
			int l = createorder.current.num;
			bu.write("; " + createorder.current.num + "; ");
			for (int i = 0; i < l; i++) {
				bu.write(createorder.current.items[i] + "; ");
			}
			bu.write(createorder.current.status);
			bu.write("\n");
			bu.close();
			orders.add(createorder.current);
			int len = orders.size();
			Order temp;
			for (int i = 0; i < len; i++) {
				temp= orders.get(i);
				System.out.print(temp.id + " ");
				System.out.print(temp.name+ " " + temp.mobile + " " + temp.address);
				int la = temp.num;
				System.out.print(" " + temp.num + " ");
				for (int j = 0; j < la; j++) {
					System.out.print(temp.items[j] + " ");
				}
				System.out.print(temp.status);
				System.out.print("\n");
			}
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
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
	    writer.println("<head>");
	    writer.println("<title>" + "details"+ "</title></head>");
	    writer.println("<body>");
		if(createorder.current==null){
			writer.println("You follwed an invalid link! Please go back to the");
			writer.println("<a href='choose'>Main Menu</a><br>");
			writer.println("</body></html>");
			return;
		}
		createorder.current.name = request.getParameter("username");
		createorder.current.address = request.getParameter("address");
		createorder.current.mobile = request.getParameter("contact");
		System.out.println(request.getParameter("username")==null);

		createorder.current.status="Order Placed";
		if(createorder.current.name.length()!=0 && createorder.current.address.length()!=0 && createorder.current.mobile.length()!=0){ 
			file();
			writer.println("<font color = 'green'> Your order was placed with track id " + createorder.current.id + "!</font><br>");
			writer.println("<a href='user'>Back to User Menu</a><br>");
			writer.println("<a href='choose'>Back to Main Menu</a><br>");
			writer.println("<a href='trackorder'>Track Order</a>");
		}
		else{
			System.out.println("else");
			writer.println("<font color='red'><br>Please enter all fields<br></font>");
			writer.println("<a href='details'> Back</a>");
		}
		writer.println("</body></html>");
		createorder.current=null;
	}

}
