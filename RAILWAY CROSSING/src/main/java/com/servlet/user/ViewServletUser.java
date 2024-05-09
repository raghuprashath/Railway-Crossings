package com.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entities.CrossingsAdmin;

import operations.AdminOperations;
import operations.UserOperations;

public class ViewServletUser extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ViewServletUser() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        AdminOperations adminOps = new AdminOperations();
        List<CrossingsAdmin> crossings = adminOps.ViewAll();
        
        out.print("<h1>User Home Page</h1>");
        out.print("<div style='display: flex; justify-content: space-between;'>");
        out.print("<div>");
        out.print("<a href='ViewServletUser' style='margin-left: 20px;'>Home</a>");
        out.print("<a href='ViewFavourites' style='margin-left: 20px;'>View Favorites</a>");
        out.print("</div>");
        out.print("<div>");
        out.print("<a href='login.jsp'>Logout</a>");
        out.print("</div>");
        out.print("</div>");
        out.print("<div style='margin-top: 20px;'>");
        out.print("<form action='ViewServletUser' method='get' style='margin-left: 20px;'>");
        out.print("<label for='search'>Search Railway Crossing:</label>"); 
        out.print("<br>");
        out.print("<input type='text' id='search' name='search' placeholder='Search Crossing' style='margin-top: 5px;'>"); // Add margin-top to input box
        out.print("<input type='submit' value='Search'>");
        out.print("</form>");
        out.print("</div>");

        try {
            String searchName = request.getParameter("search");
            if (searchName != null && !searchName.isEmpty()) {
                UserOperations userOps = new UserOperations();
                CrossingsAdmin searchedCrossing = userOps.searchCrossing(searchName);
                if (searchedCrossing != null) {
                    String status = searchedCrossing.getStatus();
                    String boxColor = status.equalsIgnoreCase("Closed") ? "red" : "green";
                    String statusStyle = "background-color: " + boxColor + "; padding: 2px 5px; border-radius: 7px; color: white;";
                    out.print("<div style='border: 1px solid #ccc; padding: 10px; margin-bottom: 10px;'>");
                    out.print("<h4>" + searchedCrossing.getName() + "</h4>");
                    out.print("<p>Status:<span style='" + statusStyle + "'>" + "<strong>" + status + "</strong></span></p>");
                    out.print("<p>Person in charge:" + "<strong>" + searchedCrossing.getPerson_in_charge() + "</strong></p>");
                    out.print("<p>Train Schedule:</strong> " + "<strong>" + searchedCrossing.getTrainSchedule() + "</strong></p>");
                    out.print("<p>Landmark:" + "<strong>" + searchedCrossing.getLandmark() + "</strong></p>");
                    out.print("<p>Address:" + "<strong>" + searchedCrossing.getAddress() + "</strong></p>");
                    out.print("</div>");
                } else {
                    out.print("<p>No crossing found with the name: " + searchName + "</p>");
                }
            } else {
                for(CrossingsAdmin crs : crossings) {
                    String status = crs.getStatus();
                    String boxColor = status.equalsIgnoreCase("Closed") ? "red" : "green";
                    String statusStyle = "background-color: " + boxColor + "; padding: 2px 5px; border-radius: 7px; color: white;";
                    out.print("<div style='border: 1px solid #ccc; padding: 10px; margin-bottom: 10px;'>");
                    out.print("<h4>" + crs.getName() + "</h4>");
                    out.print("<p>Status:<span style='" + statusStyle + "'>" + "<strong>" + status + "</strong></span></p>");
                    out.print("<p>Person in charge:" + "<strong>" + crs.getPerson_in_charge() + "</strong></p>");
                    out.print("<p>Train Schedule:</strong> " + "<strong>" + crs.getTrainSchedule() + "</strong></p>");
                    out.print("<p>Landmark:" + "<strong>" + crs.getLandmark() + "</strong></p>");
                    out.print("<p>Address:" + "<strong>" + crs.getAddress() + "</strong></p>");
                    out.print("<form action='ViewServletUser?action=addFavorite' method='post'>");
                    out.print("<input type='hidden' name='crossingName' value='" + crs.getName() + "'>");
                    out.print("<input type='submit' value='ADD TO FAVORITES'>");
                    out.print("</form>");
                    out.print("</div>");
                }
            }
        } catch (Exception e) {
            System.out.println("Unknown error occurred " + e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("addFavorite".equals(action)) {
            String crossingName = request.getParameter("crossingName");
            UserOperations userOps = new UserOperations();
            userOps.addToFavorites(crossingName, response); 
        } else {
            response.sendRedirect("ViewServletUser"); 
        }
    }
}
