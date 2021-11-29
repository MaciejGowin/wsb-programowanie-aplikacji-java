package pl.wsb.programowaniejava.maciejgowin.zadanie27;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Zadanie 27");

                                                              // jdbc:mysql://localhost:3306/booking_system
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/booking_system", "root", "root");

        BookManager bookManager = new BookManager(connection);

        PreparedStatement psDelete = connection.prepareStatement("DELETE FROM books");
        psDelete.executeUpdate();

        System.out.println("Books: " + bookManager.getBooks());

        PreparedStatement ps2 = connection.prepareStatement("SELECT * FROM books WHERE title = ?");
        ps2.setString(1, "Daleko od noszy");
        List<Book> books2 = BookManager.mapAll(ps2.executeQuery());

        System.out.println("Books: " + books2);

        bookManager.addBook("isbn1", "Przeminelo z wiadrem");
        bookManager.addBook("isbn2", "Daleko od noszy");
        bookManager.addBook("isbn3", "Sto lat codziennosci");

        System.out.println("Books: " + bookManager.getBooks());
    }
}
