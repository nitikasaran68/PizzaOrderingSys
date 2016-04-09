

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class trackorder
 */
@WebServlet("/trackorder")
public class trackorder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Order current1;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public trackorder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("loaded");
		response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>" + "trackorder"+ "</title></head>");
        writer.println("<body>");
        writer.println("<h3>");
		writer.println("<form action='trackorder' method = \"get\">");
		writer.println("please enter your details");
		writer.println("<p>");
		writer.println("Order ID*: <input type='text' name='orderid' value=''>");
		System.out.println("yo");
		writer.println("<p>");
		writer.println("<input type='submit' value='Submit'>");
		writer.println("</form>");
		writer.println("<p>");
		if(request.getParameter("orderid")!=null && request.getParameter("orderid").length()!=0){
			current1 = new Order(request.getParameter("orderid").trim());
			filestuff(response);
		}
		writer.println("<a href='user'>Back to User Menu</a>");
		writer.println("<a href='choose'>Back to Main Menu</a>");
		writer.println("</body>");
		writer.println("</html>");
		System.out.println(trackorder.current1==null);

		//trackorder.current1.id = request.getParameter("orderid");
		//String ord= request.getParameter("orderid");
	}
	void filestuff(HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

		FileReader in = new FileReader("/Users/apple/Desktop/workspace/testweb/src/orderlist.txt");
		BufferedReader bu=new BufferedReader(in);
		String line;
		String[] temp;
		int count=0;
		while((line=bu.readLine())!=null)
		{
			System.out.println(line);
			//int index = -1;
			temp=line.split(";");
			if(temp[0].equals(current1.id))
				{
					System.out.println("haan");
					writer.println("Stage is:" + temp[temp.length-1] + "<br>");
					count++;
					break;
				}
		}
		if(count==0){
			writer.println("<br>Please enter valid order ID<br>");
		}
		bu.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
