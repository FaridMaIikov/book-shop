package az.booking.bookshop.service;

import az.booking.bookshop.entity.User;
import az.booking.bookshop.exception.UserNotFoundException;
import az.booking.bookshop.model.response.UserDTO;
import az.booking.bookshop.model.mapper.CustomMapper;
import az.booking.bookshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CustomMapper userMapper;

    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("user not found"));
        return userMapper.userToUserDTO(user);
    }

    public List<UserDTO> getAllUser() {
        List<User> users = userRepository.findAll();
        return userMapper.userToUserDTO(users);
    }

}
