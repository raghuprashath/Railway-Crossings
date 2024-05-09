package com.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entities.CrossingsAdmin;

import operations.AdminOperations;

public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        public SearchServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		AdminOperations  ao = new AdminOperations();
		CrossingsAdmin crs = ao.SearchCrossings(name);
		if(crs!=null)
		{
			out.print("<a href='ViewCrossings'>Home</a>");
			out.print("<br>");
			out.print("<table width='100%' border='1'>");
			out.print("<tr><th>Sno</th><th>Name</th><th>Address</th><th>LandMark</th><th>Train Schedule</th><th>Person in charge"
					+ "<th>Status</th></th></tr>");
			out.print("<tr>");
			out.print("<td>" + crs.getSno()+ "</td>");
			out.print("<td>" + crs.getName() + "</td>");
			out.print("<td>" + crs.getAddress() + "</td>");
			out.print("<td>" + crs.getLandmark()+ "</td>");
			out.print("<td>" + crs.getTrainSchedule()+ "</td>");
			out.print("<td>" + crs.getPerson_in_charge()+ "</td>");
			out.print("<td>" + crs.getStatus()+ "</td>");
			out.print("</tr></table>");
		}
		else
		{
			out.print("<h1 style='text-align:center'>Crossing Not Found</h1> ");			
		}
	}
}
