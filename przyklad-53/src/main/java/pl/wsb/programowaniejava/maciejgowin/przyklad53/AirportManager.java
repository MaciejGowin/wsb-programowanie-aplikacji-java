package pl.wsb.programowaniejava.maciejgowin.przyklad53;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.String.format;

public class AirportManager implements AutoCloseable {

    private final Statement statement;

    public AirportManager(Connection connection) throws SQLException {
        this.statement = connection.createStatement();
    }

    public List<Airport> getAirports() throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM airports");
        List<Airport> airports = new ArrayList<>();
        while (resultSet.next()) {
            airports.add(asAirport(resultSet));
        }
        return airports;
    }

    public Optional<Airport> getAirport(String code) throws SQLException {
        ResultSet resultSet = statement.executeQuery(format("SELECT * FROM airports WHERE code = \"%s\"", code));
        if (resultSet.next()) {
            return Optional.of(asAirport(resultSet));
        } else {
            return Optional.empty();
        }
    }

    public void addAirport(Airport airport) throws SQLException {
        statement.executeUpdate(format("INSERT INTO airports VALUES (\"%s\", \"%s\", %f, %f)",
                airport.getCode(), airport.getName(), airport.getLatitude(), airport.getLongitude()));
    }

    public void updateAirport(Airport airport) throws SQLException {
        statement.executeUpdate(format("UPDATE airports SET name = \"%s\", latitude = %f, longitude = %f WHERE code = \"%s\"",
                airport.getName(), airport.getLatitude(), airport.getLongitude(), airport.getCode()));
    }

    public void deleteAirports() throws SQLException {
        statement.executeUpdate("DELETE FROM airports");
    }

    private Airport asAirport(ResultSet resultSet) throws SQLException {
        return new Airport(
                resultSet.getString(1), resultSet.getString(2),
                resultSet.getDouble(3), resultSet.getDouble(4));
    }

    @Override
    public void close() throws SQLException {
        if (statement != null) {
            statement.close();
        }
    }
}
