package org.payment.controller;

import lombok.RequiredArgsConstructor;
import org.payment.model.PaymentDto;
import org.payment.service.PaymentService;
import org.springframework.web.bind.annotation.*;
import user.dto.ProductDTO;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping("/{userId}/product")
    public List<ProductDTO> getProductsByUserId(@PathVariable Long userId) {
        return paymentService.getUserProducts(userId);
    }

    @PostMapping("/payment")
    public ProductDTO executePayment(@RequestBody PaymentDto paymentDto) {
        return paymentService.executePayment(paymentDto);
    }
}
