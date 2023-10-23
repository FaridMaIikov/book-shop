package az.booking.bookshop.service;

import az.booking.bookshop.entity.Author;
import az.booking.bookshop.exception.NotFoundException;
import az.booking.bookshop.model.response.AuthorDTO;
import az.booking.bookshop.model.mapper.CustomMapper;
import az.booking.bookshop.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final CustomMapper authorMapper;

    public List<AuthorDTO> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authorMapper.authorToAuthorDTO(authors);
    }

    public AuthorDTO getAuthorByFullName(String fullName) {
        Author author = authorRepository.findAuthorByFullName(fullName)
                .orElseThrow(() -> new NotFoundException("No author found with this name"));
        return authorMapper.authorToAuthorDTO(author);
    }
}
