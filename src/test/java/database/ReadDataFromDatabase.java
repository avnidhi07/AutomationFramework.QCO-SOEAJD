package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ReadDataFromDatabase {

	public static void main(String[] args) throws Throwable {
		
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Qspiders_info ", "root", "Scott@123");
		
		Statement stat = connection.createStatement();
		String query = "SELECT * FROM STUDENT_INFORM WHERE ID IN(3,5,7)";
		ResultSet result = stat.executeQuery(query);
		
		while(result.next()) {
			System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
		}
		connection.close();
		
			
			
	}

}
