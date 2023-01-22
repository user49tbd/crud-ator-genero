package contro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conn {
	Connection c;
	public Connection getCon() throws SQLException {
		
		//String url = "jdbc:mariadb://localhost:3306/atgen";
		String url = "jdbc:mariadb://localhost:3306/atgen2";
		String user = "root";
		String pass = "12345";
		
		c = DriverManager.getConnection(url,user,pass);
		System.out.println("connected");
		return c;
	}
}
