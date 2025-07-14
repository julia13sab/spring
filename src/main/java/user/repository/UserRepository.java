package user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import user.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
