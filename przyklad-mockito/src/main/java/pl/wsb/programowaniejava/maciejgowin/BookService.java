package pl.wsb.programowaniejava.maciejgowin;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public String getTitle(int id) {
        return bookRepository.find(id).getTitle();
    }

    public int addTitle(String title) {
        return bookRepository.save(Book.builder().title(title).build());
    }

    public Book getBook(int id) {
        return bookRepository.find(id);
    }

    public Book getBookByTitle(String title) {
        return bookRepository.findAll().stream()
                .filter(book -> title != null && title.equals(book.getTitle()))
                .findFirst()
                .orElse(null);
    }

    public long countByTitle(String title) {
        return bookRepository.findAll().stream()
                .filter(book -> title != null && title.equals(book.getTitle()))
                .count();
    }

    public boolean hasTitle(String title) {
        return countByTitle(title) > 0;
    }
}
