package com.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entities.CrossingsAdmin;
import operations.AdminOperations;

@WebServlet("/add") 
public class AddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public AddServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sno=Integer.parseInt(request.getParameter("sno"));
        String name=request.getParameter("name");
        String address=request.getParameter("address");
        String landmark=request.getParameter("landmark");
        String time=request.getParameter("time");
        String person=request.getParameter("person");
        String status=request.getParameter("status");
        CrossingsAdmin crs=null;
        try {
            crs=new CrossingsAdmin();
            crs.setSno(sno);
            crs.setName(name);
            crs.setAddress(address);
            crs.setLandmark(landmark);
            crs.setTrainSchedule(time);
            crs.setPerson_in_charge(person);
            crs.setStatus(status);
            AdminOperations ao=new AdminOperations();
            ao.AddCrossings(crs);
            response.sendRedirect("ViewCrossings");
        }catch (Exception e) {
            System.out.println("Unable to add Crossings "+e);
        }
    }
}
