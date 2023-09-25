package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertDataToDB {

	public static void main(String[] args) throws Throwable {
		
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "Scott@123");
   
		/*   Statement stat = connection.createStatement();
		String query = "insert into student_inform(first_name,last_name,address)values('axar','patel','gujrat')";
		int result = stat.executeUpdate(query);  */
		
		PreparedStatement ps = connection.prepareStatement("insert into register values('deepak','dp@123gmail.com','deepak','male','chandigarh')");
		int result = ps.executeUpdate();
		
		
		
		
		if(result==1){             // OR if(result>0)
		System.out.println("data updated");
    }
		else {
			System.out.println("data not updated");
		}

}
}
