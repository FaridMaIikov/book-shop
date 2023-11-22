package az.booking.bookshop.controller;

import az.booking.bookshop.model.request.CommentRequest;
import az.booking.bookshop.model.response.CommentResponse;
import az.booking.bookshop.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping
    public List<CommentResponse> getAllComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/{id}")
    public CommentResponse getCommentById(@PathVariable Long id){
        return commentService.getCommentById(id);
    }

    @PostMapping
    public void add(@RequestBody @Valid CommentRequest commentRequest){
        commentService.add(commentRequest);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id,
                       @RequestBody CommentRequest commentRequest){
        commentService.update(id, commentRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        commentService.delete(id);
    }

}
