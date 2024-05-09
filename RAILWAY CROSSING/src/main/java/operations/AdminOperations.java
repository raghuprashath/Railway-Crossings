package operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.connection.DbConnection;
import com.entities.CrossingsAdmin;

public class AdminOperations {
	Connection con = null;
	public AdminOperations()
	{
		con = DbConnection.getConnection();
	}
	
	public int AddCrossings(CrossingsAdmin crs)
	{
		int res = -1;
		try {
			PreparedStatement  psObj = con.prepareStatement("INSERT INTO CROSSINGS(sno,Name,Address,Landmark,Trainschedule,Person_in_charge,status) VALUES(?,?,?,?,?,?,?)");
			psObj.setInt(1, crs.getSno());
			psObj.setString(2, crs.getName());
			psObj.setString(3, crs.getAddress());
			psObj.setString(4,crs.getLandmark());
			psObj.setString(5,crs.getTrainSchedule());
			psObj.setString(6,crs.getPerson_in_charge());
			psObj.setString(7,crs.getStatus());
			res = psObj.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("cannot add crossings "+e);
		}
		return res;
	}
	public List<CrossingsAdmin >  ViewAll()
	{
		List<CrossingsAdmin >  crsall = new ArrayList<CrossingsAdmin >();
		CrossingsAdmin crs = null;
		try {
			PreparedStatement psObj = con.prepareStatement("select * from crossings");
			ResultSet rs = psObj.executeQuery();
			while(rs.next())
			{
				crs = new CrossingsAdmin ();
				crs.setSno(rs.getInt("sno"));
				crs.setName(rs.getString("name"));
				crs.setAddress(rs.getString("address"));
				crs.setLandmark(rs.getString("landmark"));
				crs.setTrainSchedule(rs.getString("trainSchedule"));
				crs.setPerson_in_charge(rs.getString("Person_in_charge"));
				crs.setStatus(rs.getString("status"));
				crsall.add(crs);
			}
			
		} catch (Exception e) {
			System.out.println("There is Problem in Viewing Data"+ e);
		}
		return crsall;
	}
	public int DeleteCrossings(int sno)
	{
		int res = -1;
		try {
			PreparedStatement psObj = con.prepareStatement("delete from crossings where sno=?");
			psObj.setInt(1, sno);
			res = psObj.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error in Deleting the Crossings "+ e);
		}
		return res;
	}
	public CrossingsAdmin SearchCrossings(String name)
	{
		CrossingsAdmin crs = null;
		try {
			PreparedStatement psObj = con.prepareStatement("select * from crossings where name=?");
			psObj.setString(1, name);
			ResultSet rs = psObj.executeQuery();
			if(rs.next())
			{
				crs = new CrossingsAdmin ();
				crs.setSno(rs.getInt("sno"));
				crs.setName(rs.getString("name"));
				crs.setAddress(rs.getString("address"));
				crs.setLandmark(rs.getString("landmark"));
				crs.setTrainSchedule(rs.getString("trainSchedule"));
				crs.setPerson_in_charge(rs.getString("Person_in_charge"));
				crs.setStatus(rs.getString("status"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return crs;
	}
	public int UpdateCrossings(CrossingsAdmin crossing) {
	    int res = -1;
	    try {
	        PreparedStatement psObj = con.prepareStatement("UPDATE crossings SET sno=?, name=?, address=?, landmark=?, trainSchedule=?, Person_in_charge=?, status=? WHERE sno=?");
	        psObj.setInt(1, crossing.getSno());
	        psObj.setString(2, crossing.getName());
	        psObj.setString(3, crossing.getAddress());
	        psObj.setString(4, crossing.getLandmark());
	        psObj.setString(5, crossing.getTrainSchedule());
	        psObj.setString(6, crossing.getPerson_in_charge());
	        psObj.setString(7, crossing.getStatus());
	        psObj.setInt(8, crossing.getSno()); 
	        res = psObj.executeUpdate();
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	    return res;
	}

}
