package az.booking.bookshop.controller;

import az.booking.bookshop.model.response.AuthorResponse;
import az.booking.bookshop.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping
    public List<AuthorResponse> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("full-name")
    public AuthorResponse getAuthorByFullName(@RequestParam(name = "fullName") String fullName) {
        return authorService.getAuthorByFullName(fullName);
    }
}
