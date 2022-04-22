package Pack;

import java.util.*;
import java.sql.*;

public class create {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("Enter the name");
	String name = scanner.next(); 

	System.out.println("Enter the acc_no ");
	int acc_no = scanner.nextInt(); 
	
	System.out.println("Enter the phone_number");
	int phone_no = scanner.nextInt();
	
	System.out.println("Enter the ifsc_code");
	String ifsc = scanner.next();
	
	System.out.println("Enter the balance");
	int balance = scanner.nextInt();
	

	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","Pass@123");
	PreparedStatement stmt = con.prepareStatement("insert into bank values(?,?,?,?,?)");
	
	stmt.setString(1, name);
	stmt.setInt(2, acc_no);
	stmt.setInt(3, phone_no);
	stmt.setString(4, ifsc);
	stmt.setInt(5, balance);
	
	stmt.execute();
	con.close();
	System.out.println("Successfully created");
	}
	catch (Exception e) {
		// TODO: handle exception
		System.out.println(e);
	}
}
}
