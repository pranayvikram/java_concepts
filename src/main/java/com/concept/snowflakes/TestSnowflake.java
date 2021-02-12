package com.concept.snowflakes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class TestSnowflake {

    private static String connectionString = "jdbc:snowflake://to52073.east-us-2.azure.snowflakecomputing.com/";
    private static String simpleSelectQuery = "SELECT * FROM SALES_DB.DEV1.AUTHORITIES";

    public static void main(String... str) {
        TestSnowflake test = new TestSnowflake();
        test.test();
    }

    private Connection getSnowflakeConnection() throws SQLException {
        return DriverManager.getConnection(connectionString, getConfiguration());
    }

    private Properties getConfiguration() {
        Properties prop = new Properties();
        prop.put("user", "pranayvikram");
        prop.put("password", "<change-it>");
        prop.put("db", "SALES_DB");
        prop.put("schema", "DEV1");
        prop.put("warehouse", "TEST_WH");
        prop.put("role", "sysadmin");
        return prop;
    }

    private void test() {

        try {
            Connection conn = getSnowflakeConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(simpleSelectQuery);

            while(resultSet.next()) {
                System.out.println("Success: " + resultSet.getString("USERNAME"));
            }
            conn.close();
        } catch (SQLException se) {
            System.out.println("Connection error!!");
        }
    }
}