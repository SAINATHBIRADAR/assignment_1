package Pack;


import java.util.*;

//import javax.smartcardio.ResponseAPDU;
import java.io.IOException;

import java.io.PrintWriter;
import java.sql.*;
import java.io.*;
public class check {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
//		System.out.println("Enter the first_name");
//		String first_name = scanner.next(); 

//		System.out.println("Enter the last_name ");
//		String last_name = scanner.next(); 
		
		
		
		System.out.println("Enter the acc_no");
		int acc_no = scanner.nextInt();
		
		System.out.println("Enter the phone_number");
		int phone_no = scanner.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","Pass@123");
			PreparedStatement stmt = con.prepareStatement("select balance from bank where acc_no = ? and phone = ?");
			
//			stmt.setString(1, name);
			stmt.setInt(1, acc_no);
			stmt.setInt(2, phone_no);
			ResultSet rs = stmt.executeQuery();
//			PrintWriter out = response.getWriter();
			while(rs.next())
			{
				System.out.println(rs.getInt(1) + " : " + rs.getInt(2));
			}
//			con.close();
			System.out.println("successfully checked");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}
