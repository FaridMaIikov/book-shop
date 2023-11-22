package az.booking.bookshop.controller;

import az.booking.bookshop.model.request.SignUpRequest;
import az.booking.bookshop.model.request.UserRequest;
import az.booking.bookshop.model.response.UserResponse;
import az.booking.bookshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping
    public List<UserResponse> getAllUser(){
        return userService.getAllUser();
    }

    @PostMapping
    public void add(@RequestBody @Valid SignUpRequest signUpRequest) {
        userService.add(signUpRequest);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable Long id,
                       @RequestBody UserRequest userRequest) {
        userService.update(id, userRequest);
    }

    @DeleteMapping
    public void delete(@RequestParam String username) {
        userService.delete(username);
    }

}
