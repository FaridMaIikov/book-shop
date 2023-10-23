package az.booking.bookshop.service;

import az.booking.bookshop.entity.Book;
import az.booking.bookshop.model.mapper.CustomMapper;
import az.booking.bookshop.model.response.BookDTO;
import az.booking.bookshop.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final CustomMapper bookMapper;

    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return bookMapper.bookToBookDTO(books);
    }
}
