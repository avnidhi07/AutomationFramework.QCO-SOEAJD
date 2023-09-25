package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class InsertDataByPositionalParam {

	public static void main(String[] args) throws Throwable {
		
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "Scott@123");
		String name="smriti";
		String email="smriti@gmail.com";
		String pass="smriti123";
		String gender="female";
		String city="mumbai";
		PreparedStatement ps = con.prepareStatement("insert into register values(?,?,?,?,?)");
		ps.setString(1, name);
		ps.setString(2, email);
		ps.setString(3, pass);
		ps.setString(4, gender);
		ps.setString(5, city);
		int result = ps.executeUpdate();
		if(result>0) {
			System.out.println("data updated");
		}
		else {
			System.out.println("data not updated");
		}
		

	}

}
