package Pack;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;
import java.sql.*;

import com.mysql.cj.protocol.Resultset;

public class tesT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the first_name");
		String first_name = scanner.next(); 

		System.out.println("Enter the last_name ");
		String last_name = scanner.next(); 
		
		System.out.println("Enter the phone_number");
		int phone_no = scanner.nextInt();
		
		System.out.println("Enter the Password");
		int password = scanner.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","Pass@123");
			PreparedStatement stmt = con.prepareStatement("insert into assign values(?,?,?,?)");
			stmt.setString(1, first_name);
			stmt.setString(2, last_name);
			stmt.setInt(3, phone_no);
			stmt.setInt(4, password);
			stmt.execute();
			con.close();
			System.out.println("Successfully Registered");
//			ResultSet rs =  stmt.executeQuery();
//			
//			while(rs.next())
//			{
//				System.out.println(rs.getString(1) + ": ");
//			}

			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
