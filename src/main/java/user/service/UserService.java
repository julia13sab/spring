package user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.dto.UserDTO;
import user.mapper.UserMapper;
import user.model.UserEntity;
import user.repository.UserRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserDTO createUser(UserEntity user) {
        if (user.getUserName().isEmpty()) throw new IllegalArgumentException("Имя пользователя не должно быть пустым!");
        return userMapper.toDto(userRepository.save(user));
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toDto).toList();
    }

    public UserDTO getUserById(Integer id) {
        return userMapper.toDto(userRepository.getById(id));
    }

    public UserDTO updateUser(UserEntity updatedUser) {
        return userMapper.toDto(userRepository.save(updatedUser));
    }

    public boolean deleteUser(UserEntity user) {
        userRepository.delete(user);
        return true;
    }
}
