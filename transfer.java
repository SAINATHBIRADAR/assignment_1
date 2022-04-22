package Pack;

import java.util.*;
import java.sql.*;


public class transfer {
	public static void main(String[] args) {
		Scanner  scanner = new Scanner(System.in);
		System.out.println("Enter the acc_no");
		int acc_no = scanner.nextInt();
		
		System.out.println("Enter the phone_number");
		int phone_no = scanner.nextInt();
		
		System.out.println("Enter the amount to send");
		int send = scanner.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","Pass@123");
			PreparedStatement stmt = con.prepareStatement("update bank set balance = balance - ? where acc_no = ? and phone =?");
			
			stmt.setInt(1, send);
			stmt.setInt(2, acc_no);
			stmt.setInt(3, phone_no);
			
			stmt.execute();
			con.close();
			System.out.println("Successfully updated");
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
