package com.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import operations.AdminOperations;
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeleteServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sno = request.getParameter("sno");
		AdminOperations  ao = new AdminOperations();
		int res=ao.DeleteCrossings(Integer.parseInt(sno));
		if(res>=1)
			response.sendRedirect("ViewCrossings");	
	}	
}
