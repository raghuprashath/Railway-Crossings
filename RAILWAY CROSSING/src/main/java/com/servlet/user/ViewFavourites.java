package com.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entities.CrossingsAdmin;
import operations.UserOperations;

public class ViewFavourites extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ViewFavourites() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.print("<h1>Favorite Crossings</h1>");
        out.print("<div style='display: flex; justify-content: space-between;'>");
        out.print("<div>");
        out.print("<a href='ViewServletUser' style='margin-left: 20px;'>Home</a>");
        out.print("</div>");
        out.print("<div>");
        out.print("<a href='login.jsp'>Logout</a>");
        out.print("</div>");
        out.print("</div>");
        out.print("<p style='text-align: center;'>");

        try {
            UserOperations userOps = new UserOperations();
            List<CrossingsAdmin> favorites = userOps.getFavorites();
            for (CrossingsAdmin crossing : favorites) {
            	String status = crossing.getStatus();
                String boxColor = status.equalsIgnoreCase("Closed") ? "red" : "green";
                String statusStyle = "background-color: " + boxColor + "; padding: 2px 5px; border-radius: 7px; color: white;";
                out.print("<div style='border: 1px solid #ccc; padding: 10px; margin-bottom: 10px;'>");
                out.print("<h4>" + crossing.getName() + "</h4>");
                out.print("<p>Status:<span style='" + statusStyle + "'>" + "<strong>" + status + "</strong></span></p>");
                out.print("<p>Person in charge: <strong>" + crossing.getPerson_in_charge() + "</strong></p>");
                out.print("<p>Train Schedule: <strong>" + crossing.getTrainSchedule() + "</strong></p>");
                out.print("<p>Landmark: <strong>" + crossing.getLandmark() + "</strong></p>");
                out.print("<p>Address: <strong>" + crossing.getAddress() + "</strong></p>");
                out.print("<form action='ViewFavourites' method='post'>");
                out.print("<input type='hidden' name='action' value='removeFavorite'>");
                out.print("<input type='hidden' name='crossingName' value='" + crossing.getName() + "'>");
                out.print("<input type='submit' value='Remove from Favorites'>");
                out.print("</form>");
                out.print("</div>");
            }
        } catch (Exception e) {
            out.println("Unknown error occurred " + e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("removeFavorite".equals(action)) {
            String crossingName = request.getParameter("crossingName");
            UserOperations userOps = new UserOperations();
            userOps.removeFromFavorites(crossingName);
        }
        response.sendRedirect("ViewFavourites");
    }
}
