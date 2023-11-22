package az.booking.bookshop.service;

import az.booking.bookshop.entity.Book;
import az.booking.bookshop.entity.Comment;
import az.booking.bookshop.exception.NotFoundException;
import az.booking.bookshop.model.mapper.CustomMapper;
import az.booking.bookshop.model.request.BookRequest;
import az.booking.bookshop.model.response.BookResponse;
import az.booking.bookshop.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final CommentService commentService;
    private final CustomMapper bookMapper;


    public List<BookResponse> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return bookMapper.bookToBookDTO(books);
    }

    public BookResponse getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found book " + id));
        return bookMapper.toBook(book);
    }

    public void add(BookRequest bookRequest) {
        Book book = Book.builder()
                .title(bookRequest.getTitle())
                .synopsis(bookRequest.getSynopsis())
                .build();
        bookRepository.save(book);
    }

    public void update(Long id, BookRequest bookRequest) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found book " + id));

        book.setTitle(bookRequest.getTitle());
        book.setSynopsis(bookRequest.getSynopsis());
        bookRepository.save(book);
    }

    public void delete(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found book " + id));

        List<Comment> comments = book.getComments();
        book.setComments(null);
        commentService.deleteAll(comments);
        bookRepository.delete(book);
    }
}
