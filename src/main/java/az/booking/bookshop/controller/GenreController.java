package az.booking.bookshop.controller;

import az.booking.bookshop.model.response.GenreResponse;
import az.booking.bookshop.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/genres")
public class GenreController {
    private final GenreService genreService;

    @GetMapping
    public List<GenreResponse> getAllGenres() {
        return genreService.getAllGenres();
    }

    @GetMapping("/genre-name")
    public GenreResponse getGenreByGenreName(@RequestParam("genreName") String genreName) {
        return genreService.getGenreByGenreName(genreName);
    }

}
