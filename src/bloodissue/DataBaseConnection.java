package bloodissue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection
{
	public static Connection doConnect()
	{
		Connection con=null;
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost/realjava","root","");
			 System.out.println("Connected to mysql Successfully");
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
	public static void main(String []args)
	{
		doConnect();
	}
}



//package DonorMaster;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class DataBaseConnection {
//	public static Connection doconnect() {
//		Connection con=null;
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			con=DriverManager.getConnection("jdbc:mysql://localhost/realjava", "root", "");
//			System.out.println("connected to mysql Successfully");
//			
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return con;
//	}
//
//	public static void main(String[] args) {
//		doconnect();
//
//	}
//
//}
