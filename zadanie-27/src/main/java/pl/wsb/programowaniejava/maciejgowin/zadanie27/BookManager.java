package pl.wsb.programowaniejava.maciejgowin.zadanie27;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookManager {

    private Connection connection;

    public BookManager(Connection connectionParam) {
        this.connection = connectionParam;
    }

    public void addBook(String isbn, String title) throws Exception {
        PreparedStatement psInsert = connection.prepareStatement("INSERT INTO books VALUES (?, ?)");
        psInsert.setString(1, isbn);
        psInsert.setString(2, title);
        psInsert.executeUpdate();
    }

    public List<Book> getBooks() throws Exception {
        PreparedStatement ps3 = connection.prepareStatement("SELECT * FROM books");
        return mapAll(ps3.executeQuery());
    }

    public static List<Book> mapAll(ResultSet resultSet) throws Exception {
        List<Book> books = new ArrayList<>();
        while (resultSet.next()) {
            books.add(map(resultSet));
        }
        return books;
    }

    public static Book map(ResultSet resultSet) throws Exception {
        return new Book(resultSet.getString(1), resultSet.getString(2));
    }
}
