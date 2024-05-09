package com.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import com.connection.*;
@WebServlet("/RegisterServlet")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        	Connection con=null;
        try {
            con=DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from user where email=?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                PrintWriter out = response.getWriter();
                out.println("<html><body>");
                out.println("<h3>User Already Registered</h3>");
                out.println("<a href='login.jsp'>Login</a>");
                out.println("</body></html>");
            } else {
                PreparedStatement ps2 = con.prepareStatement("insert into user(name,email,password) values(?,?,?)");
                ps2.setString(1, name);
                ps2.setString(2, email);
                ps2.setString(3, password);
                ps2.executeUpdate();
                response.sendRedirect("login.jsp");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
