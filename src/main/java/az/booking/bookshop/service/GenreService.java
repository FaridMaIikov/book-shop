package az.booking.bookshop.service;

import az.booking.bookshop.entity.Genre;
import az.booking.bookshop.exception.NotFoundException;
import az.booking.bookshop.model.mapper.CustomMapper;
import az.booking.bookshop.model.response.GenreResponse;
import az.booking.bookshop.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreService {
    private final GenreRepository genreRepository;
    private final CustomMapper genreMapper;

    public List<GenreResponse> getAllGenres() {
        List<Genre> genres = genreRepository.findAll();
        return genreMapper.genreToGenreDTO(genres);
    }

    public GenreResponse getGenreByGenreName(String genreName) {
        Genre genre = genreRepository.findByGenreName(genreName)
                .orElseThrow(() -> new NotFoundException("No genre found with this name"));
        return genreMapper.genreToGenreDTO(genre);
    }
}
