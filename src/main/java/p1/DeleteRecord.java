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
@WebServlet("/delete")
public class DeleteRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
    public DeleteRecord() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    }
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_1","root","Khushi123@k");
			java.sql.Statement stmt = con.createStatement();
			stmt.executeUpdate("Delete from record where email='"+email+"'"); 
			con.close();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
				
	}

}
