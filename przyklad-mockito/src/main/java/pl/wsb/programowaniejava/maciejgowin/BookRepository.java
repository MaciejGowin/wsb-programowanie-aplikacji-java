package pl.wsb.programowaniejava.maciejgowin;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private final List<Book> books = new ArrayList<>();

    public int save(Book book) {
        int id = books.size();
        books.add(Book.builder()
                .id(id)
                .title(book.getTitle())
                .build());
        return id;
    }

    public Book find(int id) {
        return books.stream()
                .filter(book -> id == book.getId())
                .findFirst()
                .orElse(null);
    }

    public List<Book> findAll() {
        return books;
    }
}
