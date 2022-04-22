package Pack;

import java.util.*;
import java.sql.*;

public class display1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.println("Enter the acc_no");
		int acc_no = scanner.nextInt();
		
		System.out.println("Enter the phone_number");
		int phone_no = scanner.nextInt();
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","Pass@123");
		PreparedStatement stmt = con.prepareStatement("select * from bank where acc_no = ? and phone =?");
		stmt.setInt(1, acc_no);
		stmt.setInt(2, phone_no);
		
		ResultSet rs = stmt.executeQuery();
		rs.next();
		System.out.println(rs.getString("name") + ":"+rs.getInt("acc_no")+":" +rs.getInt("phone") +":" + rs.getString("ifsc")+":"+rs.getInt("balance"));
		
		con.close();
		System.out.println("successgully displayed");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

}
