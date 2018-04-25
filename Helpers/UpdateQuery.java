package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.DroneService;
import model.Part;



public class UpdateQuery {
	
	private Connection connection;
	
	public UpdateQuery(String dbName, String uname, String pwd){
		
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void doUpdateService(DroneService service){
		String query = "update droneservice set serviceid=?, droneid=?, employeeid=?, description=?"
				+ "where droneid=?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, service.getServiceID());
			ps.setInt(2, service.getDroneID());
			ps.setInt(3, service.getEmployeeID());
			ps.setString(4, service.getDescription());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void doUpdatePart(Part part){
		String query = "update part set partid=?, serialnum=?, expirationdate=?, supplierid=?,"
				+ "state=?, reorderLevel=?, amount=? where partid=?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, part.getPartID());
			ps.setString(2, part.getSerialNum());
			ps.setDate(3, part.getExpirationDate());
			ps.setString(4, part.getSupplierID());
			ps.setString(5, part.getCondition());
			ps.setInt(6, part.getReorderLevel());
			ps.setInt(7, part.getAmount());
			ps.setInt(8, part.getPartID());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
