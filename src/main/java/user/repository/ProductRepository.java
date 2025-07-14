package user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import user.model.ProductEntity;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByUserId(Long userId);
}
