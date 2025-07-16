package org.payment.service;

import lombok.RequiredArgsConstructor;
import org.payment.exception.PaymentException;
import org.payment.model.PaymentDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import user.dto.ProductDTO;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final RestTemplate paymentRestTemplate;

    public List<ProductDTO> getUserProducts(Long userId) {
        final var products = paymentRestTemplate.getForEntity(String.format("/user/%s", userId), ProductDTO[].class);

        return List.of(Objects.requireNonNull(products.getBody()));
    }

    public ProductDTO executePayment(PaymentDto paymentDto) {
        final var product = paymentRestTemplate.getForEntity(String.format("/user/%s/%s", paymentDto.getUserId(), paymentDto.getProductId()), ProductDTO.class).getBody();

        if (paymentDto.getAmount().compareTo(product.getBalance()) > 0) {
            throw new PaymentException(String.format("Для продукта с id = %s не хватает денег на счете!", paymentDto.getProductId()));
        }

        product.setBalance(product.getBalance().subtract(paymentDto.getAmount()));

        return paymentRestTemplate.patchForObject("", product, ProductDTO.class);
    }
}