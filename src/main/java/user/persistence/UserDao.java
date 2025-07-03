package user.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import user.model.User;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.List;

@Component
@RequiredArgsConstructor
public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    /**
     * Создание нового пользователя
     */
    public int create(User user) {
        return jdbcTemplate.update(
                "INSERT INTO users(id, username) VALUES(?, ?)",
                user.getId(), user.getUsername()
        );
    }

    /**
     * Получение всех пользователей
     */
    public List<User> findAll() {
        return jdbcTemplate.query(
                "SELECT id, username FROM users",
                (rs, rowNum) ->
                        new User(rs.getLong("id"), rs.getString("username"))
        );
    }

    /**
     * Поиск пользователя по уникальному идентификатору
     */
    public User findById(long id) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT id, username FROM users WHERE id=?",
                    new Object[] { id },
                    (rs, rowNum) ->
                            new User(rs.getLong("id"), rs.getString("username"))
            );
        } catch(Exception e){
            return null;
        }
    }

    /**
     * Обновление имени пользователя
     */
    public int update(User user) {
        return jdbcTemplate.update(
                "UPDATE users SET username= ? WHERE id =?",
                user.getUsername(), user.getId()
        );
    }

    /**
     * Удаление пользователя по идентификатору
     */
    public int delete(long id) {
        return jdbcTemplate.update(
                "DELETE FROM users WHERE id = ?", id
        );
    }
}
