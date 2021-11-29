package pl.wsb.programowaniejava.maciejgowin.przyklad54;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

public class CustomerManager {

    private Connection connection;

    public CustomerManager(Connection connection) {
        this.connection = connection;
    }

    public List<Customer> getCustomers() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM customers");
            List<Customer> airports = new ArrayList<>();
            while (resultSet.next()) {
                airports.add(asCustomer(resultSet));
            }
            return airports;
        }
    }

    public Optional<Integer> addCustomer(String firstName, String lastName, LocalDate dateOfBirth) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO customers(first_name, last_name, date_of_birth) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setDate(3, asDate(dateOfBirth).orElse(null));
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                return Optional.of(resultSet.getInt(1));
            } else {
                return Optional.empty();
            }
        }
    }

    public void deleteCustomers() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("DELETE FROM customers");
        }
    }

    private Customer asCustomer(ResultSet resultSet) throws SQLException {
        return new Customer(
                resultSet.getInt(1), resultSet.getString(2),
                resultSet.getString(3), asLocalDate(resultSet.getDate(4)).orElse(null));
    }

    private Optional<Date> asDate(LocalDate localDate) {
        return ofNullable(localDate).map(Date::valueOf);
    }

    private Optional<LocalDate> asLocalDate(Date date) {
        return ofNullable(date).map(Date::toLocalDate);
    }
}
