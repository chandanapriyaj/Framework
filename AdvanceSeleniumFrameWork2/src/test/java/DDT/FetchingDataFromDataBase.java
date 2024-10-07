package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class FetchingDataFromDataBase {

	public static void main(String[] args) throws Throwable {
		//step1:- Register/load mysql database
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		
		//Step2:-get the connection of database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advanceselenium", "root", "root");
		
		//step3:-create a SQL Statement
        Statement state = conn.createStatement();
        String query = "select * from student";
        
       ResultSet result = state.executeQuery(query);
       while (result.next())
       {
		System.out.println("result.getInt(1)+\"\\t\"+ result.getString(2)+\"\\t\"+ result.getString(3)+\"\\t\"+result.getString(4)");
	}
       conn.close();
	}

}
