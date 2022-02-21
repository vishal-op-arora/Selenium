package utilties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/*
 * Java Database Connectivity with MySQL
	To connect Java application with the MySQL database, we need to follow 5 following steps.

	In this example we are using MySql as the database. So we need to know following informations for the mysql database:

	1. Driver class: The driver class for the mysql database is com.mysql.jdbc.Driver.
	2. Connection URL: The connection URL for the mysql database is jdbc:mysql://localhost:3306/sonoo where jdbc is the API, mysql is the database, localhost is the server name on which mysql is running, we may also use IP address, 3306 is the port number and sonoo is the database name. We may use any database, in such case, we need to replace the sonoo with our database name.
	3. Username: The default username for the mysql database is root.
	4. Password: It is the password given by the user at the time of installing the mysql database. In this example, we are going to use root as the password.
		Let's first create a table in the mysql database, but before creating table, we need to create database first.
		
		link : https://www.javatpoint.com/example-to-connect-to-the-mysql-database
 */

public class DBManager {

	private static Connection con = null; // sql
	private static Connection conn = null; // mysql

	// SQL Server
	public static void setDbConnection()  {
		try {
			Class.forName(TestConfig.driver);
			con = DriverManager.getConnection(TestConfig.dbConnectionUrl, TestConfig.dbUserName, TestConfig.dbPassword);

			if (!con.isClosed())
				System.out.println("Successfully connected to SQL server");

		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());

			// monitoringMail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to,
			// TestConfig.subject+" - (Script failed with Error, Datamart database used for
			// reports, connection not established)", TestConfig.messageBody,
			// TestConfig.attachmentPath, TestConfig.attachmentName);
		}

	}

	// MySQL Server
	public static void setMysqlDbConnection() {
		try {

			Class.forName(TestConfig.mysqldriver);
			conn = DriverManager.getConnection(TestConfig.mysqlurl, TestConfig.mysqluserName, TestConfig.mysqlpassword);
			if (!conn.isClosed())
				System.out.println("Successfully connected to MySQL server");

		} catch (Exception e) {
			System.err.println("Cannot connect to database server");

			// monitoringMail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to,
			// TestConfig.subject+" - (Script failed with Error, Datamart database used for
			// reports, connection not established)", TestConfig.messageBody,
			// TestConfig.attachmentPath, TestConfig.attachmentName);
		}

	}

	public static List<String> getQuery(String query) throws SQLException {

		// String Query="select top 10* from ev_call";
		Statement St = con.createStatement();
		ResultSet rs = St.executeQuery(query);
		List<String> values = new ArrayList<String>();
		while (rs.next()) {

			values.add(rs.getString(1));
		}
		return values;
	}

	public static List<String> getMysqlQuery(String query) throws SQLException {

		Statement St = conn.createStatement();
		ResultSet rs = St.executeQuery(query);
		List<String> values1 = new ArrayList<String>();
		while (rs.next()) {

			values1.add(rs.getString(1));

		}
		return values1;
	}

	public static Connection getConnection() {
		return con;
	}
}