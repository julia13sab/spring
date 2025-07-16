package user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import user.dto.ProductDTO;
import user.exception.ProductNotFoundException;
import user.mapper.ProductMapper;
import user.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<ProductDTO> getProductsByUserId(Long userId) {
        return productRepository.findByUserId(userId).stream()
                .map(productMapper::toDto)
                .toList();
    }

    public ProductDTO getProductById(Long productId) {
        final var optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException(String.format("Продукт с id = %s не найден!", productId));
        }
        return productMapper.toDto(optionalProduct.get());
    }
}
