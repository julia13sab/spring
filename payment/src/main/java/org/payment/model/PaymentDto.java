package org.payment.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentDto {
   private Long userId;
   private Long productId;
   private BigDecimal amount;
}
