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

	private ServerClass serverClass = new ServerClass();
	public RunServlet() {
	        super();
	 }
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
	
		String time = request.getParameter("time");
		long turning = Long.parseLong(time);
	//	System.out.println(time);
		
		/*PrintWriter writer = response.getWriter();
		htmlStr = "<html><head><title>Load Test </title></head>";
		htmlStr += "<body>"; 
		htmlStr += "<table border=\"1\" bordercolor=\"#000000\">";
		htmlStr += "<tr><td><b>CardNumber</b></td><td><b>Amount</b></td><td><b>City</b></td></td><td><b>Year</b></td></td><td><b>FraudRate</b></td></tr>";
*/		
		if (turning == 0)
			LoadTest.main(null);
		
		else {
			String cardnum = request.getParameter("cardnum");
			String city = request.getParameter("city");
			String amount = request.getParameter("amount");
			String year = request.getParameter("year");	    
			int FRate = serverClass.fetchdetails(Long.parseLong(cardnum),city,Integer.parseInt(amount),Integer.parseInt(year),turning);
			 PrintWriter writer = response.getWriter();
		        String htmlResponse = "<html>";
		        htmlResponse += "<h2>Fraud Rate is: " + FRate +"</h2>";    
		        htmlResponse += "</html>";
		         
		        // return response
		        writer.println(htmlResponse);
		}
		//  htmlStr += "</body.</html>";
		//  writer.println(htmlStr);*/

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}
}
