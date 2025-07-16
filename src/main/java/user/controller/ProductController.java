package user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long productId) {
        return new ResponseEntity<>(productService.getProductById(productId), HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO product) {
        return new ResponseEntity<>(productService.updateProduct(product), HttpStatus.OK);
    }
}
