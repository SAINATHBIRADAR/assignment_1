package Pack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.Statement;

@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public update() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String id =  request.getParameter("uname");
		String phone = request.getParameter("uphone");
		String acc_no = request.getParameter("uacc_no");
		String send =  request.getParameter("usend");
//		String ifsc = request.getParameter("uifsc");
//		String balance = request.getParameter("ubalance");
//		String credited = request.getParameter("ucredited");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","Pass@123");
//			java.sql.Statement stmt = con.createStatement();
//			String s1 = "update holder set balance = balance - ? where phone = (?) and acc_no = (?)";
//			String s2 = "update holder set credited = credited + ? where phone = ? and acc_no = ?";
			PreparedStatement stmt = con.prepareStatement("update holder set balance = balance - ? where phone = ? and acc_no = ?");
			
//			stmt.setString(1,id);
			stmt.setString(1, send);
			stmt.setString(2, phone);
			stmt.setString(3, acc_no);
			
//			stmts.setString(1, send);
//			stmts.setString(2, phone);
//			stmts.setString(3, acc_no);
//			stmt.setString(4, ifsc);
//			stmt.setString(5, balance);
//			stmt.setString(6, credited);
//			stmt.addBatch(s1);
//			stmt.addBatch(s2);
			
//			stmt.executeBatch();
			stmt.execute();
			PreparedStatement stmt1 = con.prepareStatement("update holder set credited = credited + ? where phone = ? and acc_no = ?");
			stmt1.setString(1, send);
			stmt1.setString(2, phone);
			stmt1.setString(3, acc_no);
			
			stmt1.execute();
			
			System.out.println("Data Inserted");
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
