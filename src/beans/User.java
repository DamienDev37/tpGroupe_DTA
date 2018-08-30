package beans;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import database.Db_Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User {
	private String Name, Email, Password;
	private int Role;

	public User() {
		Name = "";
		Email = "";
		Password = "";
		Role = 0;
	}

	// ----------------------------------//

	public String getName() {
		return Name;
	}

	public String getEmail() {
		return Email;
	}

	public String getPassword() {
		return Password;
	}

	public int getRole() {
		return Role;
	}

	// ----------------------------------//

	public void setName(String name) {
		this.Name = name;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public void setPassword(String password) {
		this.Password = password;
	}

	public void setRole(int role) {
		this.Role = role;
	}

	// ----------------------------------//

	public void RegisterUser() {
		try {
			Db_Connection dbconn = new Db_Connection();
			Connection myconnection = dbconn.Connection();

			String sqlString = "INSERT INTO Users (Name,Email,Password,Role) VALUES ('" + Name + "','" + Email + "','"
					+ Password + "', " + Role + ")";

			Statement myStatement = myconnection.createStatement();

			try {
				myStatement.executeUpdate(sqlString);
				myStatement.close();
				myconnection.close();
			} catch (SQLException ex) {
				Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
			}
		} catch (SQLException ex) {
			Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	// ----------------------------------//

	public static boolean LoginUser(String user, String pwd) {
		boolean check = false;
		try {
			Db_Connection dbconn = new Db_Connection();
			Connection myconnection = dbconn.Connection();

			PreparedStatement ps1 = myconnection
					.prepareStatement("select * from Users where Email=? and Password=?");

			ps1.setString(1, user);
			ps1.setString(2, pwd);
			ResultSet rs1 = ps1.executeQuery();
			check = rs1.next();

			myconnection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return check;
	}

	// ----------------------------------//

	public void GetUser() {
		try {
			Db_Connection dbconn = new Db_Connection();
			Connection myconnection = dbconn.Connection();

			String sqlString = "SELECT * FROM Users WHERE Email = '" + Email + "'";
			Statement myStatement = myconnection.createStatement();
			ResultSet rs = myStatement.executeQuery(sqlString);

			while (rs.next()) {
				Name = rs.getString("Name");
				Email = rs.getString("Email");
				Password = rs.getString("Password");
				Role = rs.getInt("Role");
			}

			myStatement.close();
			myconnection.close();

		} catch (SQLException ex) {
			Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	// ----------------------------------//

}