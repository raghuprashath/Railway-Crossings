package com.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entities.CrossingsAdmin;
import operations.AdminOperations;

public class ModifyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ModifyServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sno = request.getParameter("sno");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String landmark = request.getParameter("landmark");
        String time = request.getParameter("trainSchedule");
        String person = request.getParameter("person_in_charge");
        String status = request.getParameter("status");

        CrossingsAdmin crossing = new CrossingsAdmin();
        crossing.setSno(Integer.parseInt(sno));
        crossing.setName(name);
        crossing.setAddress(address);
        crossing.setLandmark(landmark);
        crossing.setTrainSchedule(time);
        crossing.setPerson_in_charge(person);
        crossing.setStatus(status);

        AdminOperations adminOperations = new AdminOperations();

        if (adminOperations.UpdateCrossings(crossing) >= 1) {
            response.sendRedirect("ViewCrossings");
        }
    }
}
