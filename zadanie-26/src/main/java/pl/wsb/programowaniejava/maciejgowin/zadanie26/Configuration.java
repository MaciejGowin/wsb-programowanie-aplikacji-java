package pl.wsb.programowaniejava.maciejgowin.zadanie26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.Collectors;

public class Configuration {
    private static final String SCHEMA_FILENAME = "schema.sql";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/booking_system", "root", "root");
    }

    public static String getSchemaSql() {
        try (InputStream input = Main.class.getClassLoader().getResourceAsStream(SCHEMA_FILENAME);
            BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            return reader.lines().collect(Collectors.joining());
        } catch (IOException ex) {
            System.out.println("Failed to load schema file");
            throw new RuntimeException(ex);
        }
    }

    public static void createSchema(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(getSchemaSql());
        }
    }
}
