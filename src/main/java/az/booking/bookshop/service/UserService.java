package az.booking.bookshop.service;

import az.booking.bookshop.entity.Account;
import az.booking.bookshop.entity.Comment;
import az.booking.bookshop.entity.User;
import az.booking.bookshop.exception.NotFoundException;
import az.booking.bookshop.model.mapper.CustomMapper;
import az.booking.bookshop.model.request.SignUpRequest;
import az.booking.bookshop.model.request.UserRequest;
import az.booking.bookshop.model.response.UserResponse;
import az.booking.bookshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final AccountService accountService;
    private final UserRepository userRepository;
    private final CustomMapper userMapper;

    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No user found with this ID"));
        return userMapper.userToUserDTO(user);
    }

    public List<UserResponse> getAllUser() {
        List<User> users = userRepository.findAll();
        return userMapper.userToUserDTO(users);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void add(SignUpRequest signUpRequest) {
        accountService.add(signUpRequest);
        User user = userMapper.signUpRequestToUser(signUpRequest);
        userRepository.save(user);
    }

    public User update(Long id, UserRequest userRequest) {
        User user = userRepository.findById(id).get();
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setContactNumber(userRequest.getContactNumber());
        return userRepository.save(user);
    }

    public void delete(String username) {
        User user = findUserByUsername(username);
        Account account = user.getAccount();
        List<Comment> reviews = user.getComments();
        reviews.forEach(r -> r.setUser(null));
        user.setAccount(null);
        userRepository.delete(user);
        accountService.delete(account);
    }

    public User findUserByUsername(String username) {
        return userRepository.findUserByAccount_Username(username);
    }
}
