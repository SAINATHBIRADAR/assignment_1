package Pack;

import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/bankdetails")
public class bankdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public bankdetails() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id =  request.getParameter("uname");
		String phone = request.getParameter("uphone");
		String acc_no = request.getParameter("uacc_no");
		String ifsc = request.getParameter("uifsc");
		String balance = request.getParameter("ubalance");
		String credited = request.getParameter("ucredited");
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","Pass@123");
			PreparedStatement stmt = con.prepareStatement("insert into holder values(?,?,?,?,?,?)");
			stmt.setString(1,id);
			stmt.setString(2, phone);
			stmt.setString(3, acc_no);
			stmt.setString(4, ifsc);
			stmt.setString(5, balance);
			stmt.setString(6, credited);
			stmt.execute();
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
