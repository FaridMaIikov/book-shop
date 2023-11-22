package az.booking.bookshop.controller;

import az.booking.bookshop.model.request.BookRequest;
import az.booking.bookshop.model.response.BookResponse;
import az.booking.bookshop.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public List<BookResponse> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public BookResponse getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/add-book")
    public void add(@RequestBody @Valid BookRequest bookRequest){
        bookService.add(bookRequest);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id,
                       @RequestBody BookRequest bookRequest){
        bookService.update(id, bookRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        bookService.delete(id);
    }
}
