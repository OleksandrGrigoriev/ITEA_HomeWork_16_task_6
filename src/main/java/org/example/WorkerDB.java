package org.example;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class WorkerDB {

    private static final String URL = "jdbc:mysql://localhost:3306/test_db";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";
    final String INSERT_NEW = "INSERT INTO test_table(product, country, destination) VALUES(?,?,?)";

    public WorkerDB() {
        registerDriver();
    }

    public void runWorking() {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.prepareStatement(INSERT_NEW);

            statement.setString(1, "banana");
            statement.setString(2, "Equador");
            statement.setString(3, "Ukraine");
            statement.execute();

            statement.setString(1, "pomelo");
            statement.setString(2, "China");
            statement.setString(3, "Ukraine");
            statement.execute();

            statement.setString(1, "coconut");
            statement.setString(2, "Thailand");
            statement.setString(3, "Ukraine");
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {}
    }

    private static void registerDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loading success!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
