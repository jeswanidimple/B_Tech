package net.finpro.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TheServlet implementation class RunServlet
 */
@WebServlet("/RunServlet")

public class RunServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 public RunServlet() {
	        super();
	 }
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		String cardnum = request.getParameter("cardnum");
		String city = request.getParameter("city");
	    String amount = request.getParameter("amount");
	    String year = request.getParameter("year");
	    
	    String time = request.getParameter("time");

	      /*getTime():It returns the number of milliseconds since 
	       * January 1, 1970, 00:00:00 GMT 
	       * represented by this date.
	       */
		int FRate = ServerClass.fetchdetails(Long.parseLong(cardnum),city,Integer.parseInt(amount),Integer.parseInt(year), Long.parseLong(time));
	    
	    PrintWriter writer = response.getWriter();
        String htmlRespone = "<html>";
        htmlRespone += "<h2>Fraud Rate is: " + FRate +"</h2>";    
        htmlRespone += "</html>";
         
        // return response
        writer.println(htmlRespone);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}
}
