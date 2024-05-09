package com.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entities.CrossingsAdmin;

import operations.AdminOperations;

public class ViewCrossings extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ViewCrossings() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		AdminOperations  ao = new AdminOperations();
		List<CrossingsAdmin>  crossings = ao.ViewAll();
		out.print("<h1>Admin Home Page</h1>");
		out.print("<div style='display: flex; justify-content: space-between;'>");
		out.print("<div>");
		out.print("<h3>Railway Crossings [ " + crossings.size() + " ]</h3>");
		out.print("<a href='ViewCrossings'>Home</a>");
		out.print("<a href='add.jsp' style='margin-left: 20px;'>Add Railway Crossing</a>");
		out.print("<a href='search.jsp' style='margin-left: 20px;'>Search Crossing</a>");
		out.print("</div>");
		out.print("<div>");
		out.print("<a href='adminlogin.jsp'>Logout</a>");
		out.print("</div>");
		out.print("</div>");
		out.print("<p style='text-align: center;'>");
		try {
			out.print("<table width='100%' border='1'>");
			out.print("<tr><th>Sno</th><th>Name</th><th>Address</th><th>LandMark</th><th>Train Schedule</th><th>Person in charge"
					+ "<th>Status</th><th>Action</th></th></tr>");
			for(CrossingsAdmin crs : crossings)
			{
				out.print("<tr>");
				out.print("<td>" + crs.getSno()+ "</td>");
				out.print("<td>" + crs.getName() + "</td>");
				out.print("<td>" + crs.getAddress() + "</td>");
				out.print("<td>" + crs.getLandmark()+ "</td>");
				out.print("<td>" + crs.getTrainSchedule()+ "</td>");
				out.print("<td>" + crs.getPerson_in_charge()+ "</td>");
				out.print("<td>" + crs.getStatus()+ "</td>");
				out.print("<td><a href='DeleteServlet?sno=" + crs.getSno() + "'>Delete</a>");
				out.print("&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;");
				out.print("<a href='UpdateServletUser?name=" + crs.getName() + "'>Update</a></td>");
				out.print("</tr>");
			}			
			out.print("</table>");
		} catch (Exception e) {
			System.out.println("Unknown error occured "+e);
		}

	}

}
