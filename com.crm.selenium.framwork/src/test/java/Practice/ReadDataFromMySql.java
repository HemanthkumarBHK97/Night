package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;

public class ReadDataFromMySql {

	public static void main(String[] args) throws Throwable {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_yantra", "root","root"); 
		Statement stat=(Statement) con.createStatement();
		//String selectQuery ="select*from student";
		ResultSet result= stat.executeQuery("select*from student");
		while(result.next()) {
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
		}
		con.close();
	}
}
