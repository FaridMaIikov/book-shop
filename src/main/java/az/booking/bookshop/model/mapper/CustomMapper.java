package az.booking.bookshop.model.mapper;

import az.booking.bookshop.entity.*;
import az.booking.bookshop.model.request.CommentRequest;
import az.booking.bookshop.model.request.SignUpRequest;
import az.booking.bookshop.model.response.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomMapper {
    Account signUpRequestToEntity(SignUpRequest request);
    User signUpRequestToUser(SignUpRequest request);
    List<RoleResponse> roleToRoleDTO(List<Role> roles);

    List<GenreResponse> genreToGenreDTO(List<Genre> genres);

    GenreResponse genreToGenreDTO(Genre genre);

    List<AccountResponse> accountToAccountDTO(List<Account> accounts);

    List<AuthorResponse> authorToAuthorDTO(List<Author> authors);

    AuthorResponse authorToAuthorDTO(Author author);

    User userDTOToUser(UserResponse userResponse);

    UserResponse userToUserDTO(User user);

    List<UserResponse> userToUserDTO(List<User> users);

    List<BookResponse> bookToBookDTO(List<Book> books);
    BookResponse toBook(Book books);

    List<CommentResponse> commentToCommentDTO(List<Comment> comments);

    CommentResponse commentToCommentDTO(Comment comment);
    Comment commentRequestToComment(CommentRequest commentRequest);

}
