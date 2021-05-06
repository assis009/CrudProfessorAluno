package application.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDao {
	
	private Connection c;
	
	public Connection getConecction() throws ClassNotFoundException, SQLException {
		
		String hostname = "localhost";
		String dbname ="dbvideojavafx";
		String user = "gabriel";
		String senha ="123456";
		
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		
		c = DriverManager.getConnection(
				String.format("jdbc:jtds:sqlserver://%s:1433;databaseName=%s;user=%s;password=%s;",
						hostname, dbname, user, senha));
		
		return c;
		
	}
}
