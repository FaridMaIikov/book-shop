package az.booking.bookshop.model.mapper;

import az.booking.bookshop.entity.*;
import az.booking.bookshop.model.response.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomMapper {
    List<RoleDTO> roleToRoleDTO(List<Role> roles);

    List<GenreDTO> genreToGenreDTO(List<Genre> genres);

    GenreDTO genreToGenreDTO(Genre genre);

    List<AccountDTO> accountToAccountDTO(List<Account> accounts);

    List<AuthorDTO> authorToAuthorDTO(List<Author> authors);

    AuthorDTO authorToAuthorDTO(Author author);

    User userDTOToUser(UserDTO userDTO);

    UserDTO userToUserDTO(User user);

    List<UserDTO> userToUserDTO(List<User> users);

    List<BookDTO> bookToBookDTO(List<Book> books);

    List<CommentDTO> commentToCommentDTO(List<Comment> comments);

    CommentDTO commentToCommentDTO(Comment comment);

}
