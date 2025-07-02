package user.service;

import lombok.RequiredArgsConstructor;
import user.model.User;
import user.persistence.UserDao;


import java.util.List;

@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    public int createUser(User user) {
        if(user.getUsername().isEmpty()) throw new IllegalArgumentException("Имя пользователя не должно быть пустым!");
        return userDao.create(user);
    }

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public User getUserById(long id) {
        return userDao.findById(id);
    }

    public int updateUser(User updatedUser) {
        return userDao.update(updatedUser);
    }

    public int deleteUser(long id) {
        return userDao.delete(id);
    }
}
