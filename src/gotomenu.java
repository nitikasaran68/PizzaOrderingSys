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

/**
 * Servlet implementation class gotomenu
 */
@WebServlet("/gotomenu")
public class gotomenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
     //  private HttpServletRequest req;
      // private HttpServletResponse resp;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gotomenu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        System.out.println("loaded");
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>" + "Menu"+ "</title></head>");
        writer.println("<body>");
        if(createorder.current==null){
			writer.println("You follwed an invalid link! Please go back to the");
			writer.println("<a href='choose'>Main Menu</a><br>");
			writer.println("</body></html>");
			return;
		}
        writer.println("<h3>");
		writer.println("<form action=\"gotomenu\" method = \"post\">");
		writer.println("choose the pizza type and specify quantity in the text area");
		writer.println("<p>");
		writer.println("<input type='checkbox' name='mpizzatype' >Margherita");
		writer.println("<input type='radio' name='mpizzasize' value='small' >Small");
		writer.println("<input type='radio' name='mpizzasize' value = 'medium'>Medium");
		writer.println("<input type='radio' name='mpizzasize' value = 'large' >Large");
		writer.println("<input type= 'number' min = 1 name='mquantity'>");
		writer.println("<br>");
		writer.println("<input type='checkbox' name='fpizzatype' value='farmhouse'>Farmhouse");
		writer.println("<input type='radio' name='fpizzasize' value='small'>Small");
		writer.println("<input type='radio' name='fpizzasize' value='medium'>Medium");
		writer.println("<input type='radio' name='fpizzasize' value='large'>Large");
		writer.println("<input type= 'number' min = 1 name='fquantity'>");
		writer.println("<br>");
		writer.println("<input type='checkbox' name='pepizzatype' value='pepperoni'>Pepperoni");
		writer.println("<input type='radio' name='pepizzasize' value='small'>Small");
		writer.println("<input type='radio' name='pepizzasize' value='medium'>Medium");
		writer.println("<input type='radio' name='pepizzasize' value='large'>Large");
		writer.println("<input type= 'number' min = 1 name='pequantity'>");
		writer.println("<br>");
		writer.println("<input type='checkbox' name='papizzatype' value='paneer'>Paneer");
		writer.println("<input type='radio' name='papizzasize' value='small'>Small");
		writer.println("<input type='radio' name='papizzasize' value='medium'>Medium");
		writer.println("<input type='radio' name='papizzasize' value='large'>Large");
		writer.println("<input type= 'number' min = 1 name='paquantity'>");
		writer.println("<br>");
		writer.println("<br>	<input type = 'submit' value='Submit' width = '100'>");
		writer.println("</form>");
		writer.println("<br>");
		writer.println("<br>");
			//writer.println(createorder.current);
	
		writer.println("</body>");
		writer.println("</html>");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>" + "Menu"+ "</title></head>");
        writer.println("<body>");
        if(createorder.current==null){
			writer.println("You follwed an invalid link! Please go back to the");
			writer.println("<a href='choose'>Main Menu</a><br>");
			writer.println("</body></html>");
			return;
		}
		boolean flag=false;
		//System.out.println(request.getParameter("mpizzatype"));
		if(request.getParameter("mpizzatype")!=null && request.getParameter("mpizzasize")!=null)
		{
			flag=true;
			System.out.println("margharita");
			String msize= request.getParameter("mpizzasize");
			String mqty="1";
			if(request.getParameter("mquantity")!=null && request.getParameter("mquantity").length()!=0)
				mqty= request.getParameter("mquantity");
			int mqtyint= Integer.parseInt(mqty);
			System.out.println(msize+mqtyint);
			createorder.current.additem("Margharita", msize, mqtyint);
		}
		
		if(request.getParameter("fpizzatype")!=null && request.getParameter("fpizzasize")!=null)
		{
			flag=true;
			System.out.println("farmhouse");
			String msize= request.getParameter("fpizzasize");
			String mqty="1";
			if(request.getParameter("fquantity")!=null && request.getParameter("fquantity").length()!=0)
				mqty= request.getParameter("fquantity");
			int mqtyint= Integer.parseInt(mqty);
			System.out.println(msize+mqtyint);
			createorder.current.additem("Farmhouse", msize, mqtyint);
		}
		
		if(request.getParameter("pepizzatype")!=null && request.getParameter("pepizzasize")!=null)
		{
			flag=true;
			System.out.println("pepperoni");
			String msize= request.getParameter("pepizzasize");
			String mqty="1";
			if(request.getParameter("pequantity")!=null && request.getParameter("pequantity").length()!=0)
				mqty= request.getParameter("pequantity");
			int mqtyint= Integer.parseInt(mqty);
			System.out.println(msize+mqtyint);
			createorder.current.additem("Pepperoni", msize, mqtyint);
		}
		
		if(request.getParameter("papizzatype")!=null && request.getParameter("papizzasize")!=null)
		{
			flag=true;
			System.out.println("paneer");
			String msize= request.getParameter("papizzasize");
			String mqty="1";
			if(request.getParameter("paquantity")!=null && request.getParameter("paquantity").length()!=0)
				mqty= request.getParameter("paquantity");
			int mqtyint= Integer.parseInt(mqty);
			System.out.println(msize+mqtyint);
			createorder.current.additem("Paneer", msize, mqtyint);
		}
		if(!flag){
			writer.println("<font color='red'><br>Please enter all fields correctly<br></font>");
			if(createorder.current.num>0)			writer.println("<a href = \"details\" > CONTINUE</a>");
			writer.println("<a href='gotomenu'> Back</a>");
		}
		else{
			writer.println("<font color='green'><br>Pizzas added<br></font>");
			writer.println("<a href='gotomenu'> Add more items</a>");
			writer.println("<a href = \"details\" > CONTINUE</a>");
		}
		writer.println("</body></html>");
	}

}
