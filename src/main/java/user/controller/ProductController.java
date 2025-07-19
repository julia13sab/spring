package user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import user.dto.ProductDTO;
import user.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/user/{userId}")
    public List<ProductDTO> getProductsByUserId(@PathVariable Long userId) {
        return productService.getProductsByUserId(userId);
    }

    @GetMapping("/user/{userId}/{productId}")
    public ProductDTO getProductByUserId(@PathVariable Long userId, @PathVariable Long productId) {
        return productService.getProductByUserId(userId, productId);
    }

    @GetMapping("/{productId}")
    public ProductDTO getProductById(@PathVariable Long productId) {
        return productService.getProductById(productId);
    }

    @PatchMapping
    public ProductDTO updateProduct(@RequestBody ProductDTO product) {
        return productService.updateProduct(product);
    }
}
