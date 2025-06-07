package pl.wsb.programowaniejava.maciejgowin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BookServicePureTest {
    private BookService bookService;
    private BookRepository bookRepository;

    @BeforeEach
    public void init() {
        bookRepository = Mockito.mock(BookRepository.class);
        bookService = new BookService(bookRepository);
    }

    @Test
    public void shouldGetTitle() {
        // given
        when(bookRepository.find(anyInt())).thenReturn(
                Book.builder().title("Dummy Title").build());

        // when
        String title = bookService.getTitle(0);

        // then
        assertThat(title).isEqualTo("Dummy Title");
    }

    @Test
    public void shouldAddTitle() {
        // given
        when(bookRepository.save(any(Book.class))).thenReturn(5);

        // when
        int id = bookService.addTitle("Dummy Title");

        // then
        assertThat(id).isEqualTo(5);

        ArgumentCaptor<Book> argumentCaptor = ArgumentCaptor.forClass(Book.class);
        verify(bookRepository, times(1)).save(argumentCaptor.capture());
        Book book = argumentCaptor.getValue();
        assertThat(book).isNotNull();
        assertThat(book.getTitle()).isEqualTo("Dummy Title");
    }
}
