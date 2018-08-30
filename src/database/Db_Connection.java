package database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Db_Connection {
	public Connection Connection() {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			String conn = "jdbc:mysql://mysql-tpjava.alwaysdata.net:3306/tpjava_db?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String user = "tpjava";
			String password = "P$fe6F9a2";
			Connection myConnection = DriverManager.getConnection(conn, user, password);
			return myConnection;
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(Db_Connection.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}
}
