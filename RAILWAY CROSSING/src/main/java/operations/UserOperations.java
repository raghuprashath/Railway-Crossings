package operations;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.connection.DbConnection;
import com.entities.CrossingsAdmin;

public class UserOperations {
    Connection con = null;

    public UserOperations() {
        con = DbConnection.getConnection();
    }

    public void addToFavorites(String crossingName, HttpServletResponse response) {
        try {
            if (!isFavorite(crossingName)) { 
                PreparedStatement psObj = con.prepareStatement("INSERT INTO favorites(name) VALUES(?)");
                psObj.setString(1, crossingName);
                int res = psObj.executeUpdate();
                if (res > 0) {
                    System.out.println("Crossing added to favorites successfully.");
                    response.sendRedirect("ViewServletUser"); 
                    return; 
                } else {
                    System.out.println("Failed to add crossing to favorites.");
                }
            } else {
                response.sendRedirect("ViewServletUser");
                return; 
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
 public boolean isFavorite(String crossingName) {
        try {
            String query = "SELECT * FROM favorites WHERE name=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, crossingName);
            ResultSet rs = ps.executeQuery();
            return rs.next(); 
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public List<CrossingsAdmin> getFavorites() {
        List<CrossingsAdmin> favorites = new ArrayList<>();
        try {
        	String query = "SELECT f.name, c.status, c.person_in_charge, c.Trainschedule, c.landmark, c.Address " +
                    "FROM favorites f " +
                    "JOIN crossings c ON f.name = c.Name";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CrossingsAdmin crossing = new CrossingsAdmin();
                crossing.setName(rs.getString("name"));
                crossing.setStatus(rs.getString("status"));
                crossing.setPerson_in_charge(rs.getString("person_in_charge"));
                crossing.setTrainSchedule(rs.getString("trainschedule"));
                crossing.setLandmark(rs.getString("landmark"));
                crossing.setAddress(rs.getString("address"));
                favorites.add(crossing);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return favorites;
    }
    public void removeFromFavorites(String crossingName) {
        try {
            PreparedStatement psObj = con.prepareStatement("DELETE FROM favorites WHERE name = ?");
            psObj.setString(1, crossingName);
            int res = psObj.executeUpdate();
            if (res > 0) {
                System.out.println("Crossing removed from favorites successfully.");
            } else {
                System.out.println("Failed to remove crossing from favorites.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public CrossingsAdmin searchCrossing(String name) {
        CrossingsAdmin crossing = null;
        try {
            String query = "SELECT * FROM crossings WHERE Name=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                crossing = new CrossingsAdmin();
                crossing.setName(rs.getString("Name"));
                crossing.setStatus(rs.getString("status"));
                crossing.setPerson_in_charge(rs.getString("person_in_charge"));
                crossing.setTrainSchedule(rs.getString("trainschedule"));
                crossing.setLandmark(rs.getString("landmark"));
                crossing.setAddress(rs.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return crossing;
    }
}