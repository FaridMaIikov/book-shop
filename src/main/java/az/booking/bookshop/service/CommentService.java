package az.booking.bookshop.service;

import az.booking.bookshop.entity.Comment;
import az.booking.bookshop.exception.NotFoundException;
import az.booking.bookshop.model.mapper.CustomMapper;
import az.booking.bookshop.model.response.CommentDTO;
import az.booking.bookshop.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final CustomMapper commentMapper;

    @Transactional
    public List<CommentDTO> getAllComments() {
        List<Comment> comments = commentRepository.getAllComments();
        return commentMapper.commentToCommentDTO(comments);
    }

    public CommentDTO getCommentById(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("This comment was not found"));
        return commentMapper.commentToCommentDTO(comment);
    }
}
