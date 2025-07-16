package user.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {
    private Long id;
    private Integer accountNumber;
    private BigDecimal balance;
    private ProductTypeEnum type;
}
