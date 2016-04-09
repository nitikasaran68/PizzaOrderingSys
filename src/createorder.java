// @authors
//Nitika Saran 2014068
//Ishita Verma 2014051

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class createorder
 */
@WebServlet("/createorder")
public class createorder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Order current;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createorder() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    String proc(LocalDateTime d){
    	String ans = d.toString();
    	char [] arr = ans.toCharArray();
    	ans ="";
    	for(char c: arr){
    		if(c!='-' && c!='.' && c!=':'){
    			ans = ans + c;
    		}
    	}
    	return ans;
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	initfile();
    	response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String trackid="ORD" + proc(LocalDateTime.now());
        current = new Order(trackid);
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>" + "user"+ "</title></head>");
        writer.println("<body>");
        writer.println("<h1>");
        writer.println("The track id of your order is: " + trackid );
        writer.println("<br>\n<a href=gotomenu>Continue to menu" );
		//writer.println(createorder.current);
		writer.println("</body");
		writer.print("</html>");
		if(current!=null) System.out.println("Order created");
		else System.out.println("Failed to create order");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	static void initfile(){
		details.orders = new ArrayList<Order>();
		try{
			FileInputStream in = new FileInputStream("/Users/apple/Desktop/workspace/testweb/src/orderlist.txt");
			BufferedReader bu = new BufferedReader(new InputStreamReader(in));
			String []temp;
			String s=bu.readLine();
			while(s!=null){
//				System.out.println("hello");
				if(s.length()==0 || s==" " || s=="\n"){ s=bu.readLine(); continue;}
				temp = s.split("; ");
				Order tempo = new Order(temp[0]);
				tempo.name = temp[1];
				tempo.mobile = temp[2];
				tempo.address = temp[3];
				int l = Integer.parseInt(temp[4]);
				for (int i = 1; i <= l; i++) {
					tempo.items[i-1] = temp[4+i];
				}
				tempo.num = l;
				tempo.status = temp[4+l+1];
				details.orders.add(tempo);
				s = bu.readLine();
			}
			bu.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
