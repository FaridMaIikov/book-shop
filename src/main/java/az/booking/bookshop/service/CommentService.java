package az.booking.bookshop.service;

import az.booking.bookshop.entity.Book;
import az.booking.bookshop.entity.Comment;
import az.booking.bookshop.exception.NotFoundException;
import az.booking.bookshop.model.mapper.CustomMapper;
import az.booking.bookshop.model.request.CommentRequest;
import az.booking.bookshop.model.response.CommentResponse;
import az.booking.bookshop.repository.BookRepository;
import az.booking.bookshop.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final BookRepository bookRepository;
    private final CommentRepository commentRepository;
    private final CustomMapper commentMapper;

    @Transactional
    public List<CommentResponse> getAllComments() {
        List<Comment> comments = commentRepository.getAllComments();
        return commentMapper.commentToCommentDTO(comments);
    }

    public CommentResponse getCommentById(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("This comment was not found"));
        return commentMapper.commentToCommentDTO(comment);
    }

    public void add(CommentRequest commentRequest) {
        Book book = bookRepository.findById(commentRequest.getBookId()).get();
        Comment comment = commentMapper.commentRequestToComment(commentRequest);
        comment.setBook(book);
        commentRepository.save(comment);
    }

    public Comment update(Long id, CommentRequest commentRequest) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found comment"));
        comment.setReviewText(commentRequest.getReviewText());
        comment.getBook().setId(commentRequest.getBookId());
        comment.getUser().setId(commentRequest.getUserId());
        return commentRepository.save(comment);
    }

    public void delete(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found comment"));
        comment.setBook(null);
        commentRepository.delete(comment);
    }

    public void deleteAll(List<Comment> comments) {
        comments.forEach(r -> r.setBook(null));
        commentRepository.deleteAll(comments);
    }
}
