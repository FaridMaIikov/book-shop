package az.booking.bookshop.controller;

import az.booking.bookshop.model.response.UserDTO;
import az.booking.bookshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping
    public List<UserDTO> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("user-email")
    public UserDTO getUserByEmail(@RequestParam String email){
        return userService.getUserByEmail(email);
    }

}
