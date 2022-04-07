package p1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
@WebServlet("/record")
public class Record extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
    public Record() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    }
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		System.out.println(name);
		System.out.println(city);
		System.out.println(email);
		System.out.println(mobile);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_1","root","Khushi123@k");
			java.sql.Statement stmt = con.createStatement();
			stmt.executeUpdate("insert into record values('"+name+"','"+city+"','"+email+"','"+mobile+"')");
			con.close();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
				
	}

}
