package com.concept.jdbcConcepts;

import java.util.*;
import java.sql.*;

public class JDBCExample {
	
	public static void main(String...strings) {
		
		String sql = "SELECT * FROM APP_USER";
		JDBCExample jdbc = new JDBCExample();
		jdbc.testResultSet(sql);
	}
	
	public void testResultSet(String sql) {
		
		String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
		String ORACLE_THIN_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
		String USER = "DEV1";
		String PASS = "password1";

		Statement stmt = null;
		ResultSet resultSet = null;
		Connection connection = null;
		List<String> columnNames = new ArrayList<String>();

		try {
			// Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// Open a connection
			connection = DriverManager.getConnection(ORACLE_THIN_URL, USER, PASS);

			// Execute SQL query
			stmt = connection.createStatement();
			resultSet = stmt.executeQuery(sql);
			if (resultSet != null) {
				ResultSetMetaData columns = resultSet.getMetaData();
				int rowNum = 0;
				while (rowNum < columns.getColumnCount()) {
					rowNum++;
					System.out.print(columns.getColumnName(rowNum) + "\t");
					columnNames.add(columns.getColumnName(rowNum));
				}
				System.out.print("\n");

				while (resultSet.next()) {
					for (rowNum = 0; rowNum < columnNames.size(); rowNum++) {
						System.out.print(resultSet.getString(columnNames.get(rowNum)) + "\t");
					}
					System.out.print("\n");
				}
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e.toString());
		}

		finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception anyEx) {
				System.out.println(anyEx.toString());
			}
		}
	}
}
