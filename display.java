package Pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.Resultset;

@WebServlet("/display")
public class display extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public display() {
        super();
        // TODO Auto-generated constructor stub
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String acc_no = request.getParameter("uacc_no");
			String phone = request.getParameter("uphone");
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","Pass@123");
				PreparedStatement stmt = con.prepareStatement("select * from holder where acc_no =? and phone= ? ");
				stmt.setString(1, acc_no);
				stmt.setString(2, phone);
				ResultSet rs = stmt.executeQuery();
				PrintWriter out = response.getWriter();
				
				while(rs.next())
				{
					out.println(rs.getString(1) + " : " + rs.getString(2));
				}
//				stmt.execute();
				out.println("Thank you");
				
				con.close();
			}
			catch (Exception e) {
				System.out.println(e);
			}
			
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
