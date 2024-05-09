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
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Connection con;
        try {
            con=DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from user where email=? and password=?");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                response.sendRedirect("ViewServletUser");
            } else {
                PrintWriter out = response.getWriter();
                out.println("<html><body>");
                out.println("<h3>Incorrect email or password</h3>");
                out.println("<a href='login.jsp'>Back to Login Page</a>");
                out.println("</body></html>");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
