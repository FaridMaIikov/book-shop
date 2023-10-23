package az.booking.bookshop.service;

import az.booking.bookshop.entity.Book;
import az.booking.bookshop.entity.Genre;
import az.booking.bookshop.model.mapper.CustomMapper;
import az.booking.bookshop.model.response.GenreDTO;
import az.booking.bookshop.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreService {
    private final GenreRepository genreRepository;
    private final CustomMapper customMapper;

    public List<GenreDTO> getAllGenres() {
        List<Genre> genres = genreRepository.findAll();
        return customMapper.genreToGenreDTO(genres);
    }

    public GenreDTO getGenreByGenreName(String genreName) {
        Genre genre = genreRepository.findByGenreName(genreName);
        List<Book> books = genre.getBooks();
        customMapper.bookToBookDTO(books);
        genre.setBooks(books);
        return customMapper.genreToGenreDTO(genre);
    }
}
