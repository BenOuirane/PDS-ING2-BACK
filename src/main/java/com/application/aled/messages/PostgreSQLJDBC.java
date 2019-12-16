package com.application.aled.messages;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * JDBC connection to fill database
 *
 */
public class PostgreSQLJDBC {
    public static Connection connection;
    public PostgreSQLJDBC() {
        connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager
                    .getConnection("jdbc:postgresql://172.31.254.61:5433/application_test",
                            "postgres", "root");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
}
