package pl.wsb.programowaniejava.maciejgowin.zadanie26;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AirportManager {

    private final Connection connection;

    public AirportManager(Connection connection) {
        this.connection = connection;
    }

    public List<Airport> getAirports() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM airports");
            List<Airport> airports = new ArrayList<>();
            while (resultSet.next()) {
                airports.add(asAirport(resultSet));
            }
            return airports;
        }
    }

    public Optional<Airport> getAirport(String code) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM airports WHERE code = ?")) {
            preparedStatement.setString(1, code);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return Optional.of(asAirport(resultSet));
            } else {
                return Optional.empty();
            }
        }
    }

    public void addAirport(Airport airport) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO airports VALUES (?, ?, ?, ?)")) {
            preparedStatement.setString(1, airport.getCode());
            preparedStatement.setString(2, airport.getName());
            preparedStatement.setDouble(3, airport.getLatitude());
            preparedStatement.setDouble(4, airport.getLongitude());
            preparedStatement.executeUpdate();
        }
    }

    public void updateAirport(Airport airport) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE airports SET name = ?, latitude = ?, longitude = ? WHERE code = ?")) {
            preparedStatement.setString(1, airport.getName());
            preparedStatement.setDouble(2, airport.getLatitude());
            preparedStatement.setDouble(3, airport.getLongitude());
            preparedStatement.setString(4, airport.getCode());
            preparedStatement.execute();
        }
    }

    public void deleteAirports() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("DELETE FROM airports");
        }
    }

    private Airport asAirport(ResultSet resultSet) throws SQLException {
        return new Airport(
                resultSet.getString(1), resultSet.getString(2),
                resultSet.getDouble(3), resultSet.getDouble(4));
    }
}
