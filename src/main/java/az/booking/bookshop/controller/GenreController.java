package az.booking.bookshop.controller;

import az.booking.bookshop.model.response.GenreDTO;
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
    public List<GenreDTO> getAllGenres() {
        return genreService.getAllGenres();
    }

    @GetMapping("/genre-name")
    public GenreDTO getGenreByGenreName(@RequestParam("genreName") String genreName) {
        return genreService.getGenreByGenreName(genreName);
    }

}
