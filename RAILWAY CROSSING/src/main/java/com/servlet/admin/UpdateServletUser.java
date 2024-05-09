package com.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.entities.CrossingsAdmin;
import operations.AdminOperations;

public class UpdateServletUser extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UpdateServletUser() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        AdminOperations ao = new AdminOperations();
        CrossingsAdmin crossing = ao.SearchCrossings(name);

        if (crossing != null) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Modify Crossing</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }");
            out.println(".form-container { width: 300px; padding: 20px; border: 1px solid #ccc; border-radius: 10px; background-color: #f9f9f9; }");
            out.println("form { margin-top: 20px; }");
            out.println("label { display: block; margin-top: 10px; }");
            out.println("input[type=radio] { margin-top: 5px; }");
            out.println("input[type=submit] { width: 100%; padding: 10px; background-color: #4CAF50; color: white; border: none; border-radius: 5px; cursor: pointer; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"form-container\">");
            out.println("<h2>Modify Crossing</h2>");
            out.println("<form action=\"ModifyServlet\" method=\"post\">");
            out.println("<input type=\"hidden\" name=\"sno\" value=\"" + crossing.getSno() + "\">");
            out.println("<label for=\"name\">Name:</label>");
            out.println("<input type=\"text\" name=\"name\" value=\"" + crossing.getName() + "\"><br>");
            out.println("<label for=\"address\">Address:</label>");
            out.println("<input type=\"text\" name=\"address\" value=\"" + crossing.getAddress() + "\"><br>");
            out.println("<label for=\"landmark\">Landmark:</label>");
            out.println("<input type=\"text\" name=\"landmark\" value=\"" + crossing.getLandmark() + "\"><br>");
            out.println("<label for=\"trainSchedule\">Train Schedule:</label>");
            out.println("<input type=\"text\" name=\"trainSchedule\" value=\"" + crossing.getTrainSchedule() + "\"><br>");
            out.println("<label for=\"person_in_charge\">Person in charge:</label>");
            out.println("<input type=\"text\" name=\"person_in_charge\" value=\"" + crossing.getPerson_in_charge() + "\"><br>");
            out.println("<label for=\"status\">Status:</label><br>");
            out.println("<input type=\"radio\" name=\"status\" value=\"Open\"" + (crossing.getStatus().equals("Open") ? " checked" : "") + "> Open<br>");
            out.println("<input type=\"radio\" name=\"status\" value=\"Closed\"" + (crossing.getStatus().equals("Closed") ? " checked" : "") + "> Closed<br><br>");
            out.println("<input type=\"submit\" value=\"Update\">");
            out.println("</form>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        } else {
            response.getWriter().println("Crossing not found.");
        }
    }
}

