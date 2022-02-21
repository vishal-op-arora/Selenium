package _02_WebElements;

import java.sql.SQLException;

import utilties.DBManager;

/*
 * Java Database Connectivity with MySQL
	To connect Java application with the MySQL database, we need to follow 5 following steps.

	In this example we are using MySql as the database. So we need to know following informations for the mysql database:

	1. Driver class: The driver class for the mysql database is com.mysql.jdbc.Driver.
	2. Connection URL: The connection URL for the mysql database is jdbc:mysql://localhost:3306/sonoo where jdbc is the API, mysql is the database, localhost is the server name on which mysql is running, we may also use IP address, 3306 is the port number and sonoo is the database name. We may use any database, in such case, we need to replace the sonoo with our database name.
	3. Username: The default username for the mysql database is root.
	4. Password: It is the password given by the user at the time of installing the mysql database. In this example, we are going to use root as the password.
		Let's first create a table in the mysql database, but before creating table, we need to create database first.

 *		link : https://www.javatpoint.com/example-to-connect-to-the-mysql-database
 */

public class Lect06_JDBC {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		DBManager.setMysqlDbConnection();
		System.out.println(DBManager.getMysqlQuery("select tutorail_autor from seleniumTable where tutorail_id=2;"));
	}

}
