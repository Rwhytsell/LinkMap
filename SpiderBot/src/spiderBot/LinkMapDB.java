package spiderBot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class LinkMapDB {
	
	public static void addNode(String parentLink, List<String> Childlist){
		
		Statement stmt = null;
		ResultSet rs = null;

		
		try {
		String url = "jdbc:mysql://linkmapdb.ccj1naqcwlsy.us-west-2.rds.amazonaws.com:3306/";
		String userName = "Rwhytsell";
		String password = "linkmapdbpassword";
		String dbName = "LinkMapDB";
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);
		
		Connection conn = DriverManager.getConnection(url + dbName, userName, password);
		
		String query = "INSERT INTO LinkMapDB.nodes (nodeParent, nodeChild) VALUES (?, ?)";
		
		PreparedStatement prepStmt = conn.prepareStatement(query);
		prepStmt.setString (1, parentLink);
		
		for(int i = Childlist.size(); i != 0; i--){
			System.out.println("For loop check");
	    prepStmt.setString (2, Childlist.get(i-1));
	    prepStmt.executeUpdate();
	    System.out.println("-Update request sent-");
		}
		
		
		conn.close();
		
		} catch (Exception e) {
		    System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		
		finally {
		

		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException e) { }

		        rs = null;
		    }

		    if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException e) { }

		        stmt = null;
		    }
		}
	}
}
