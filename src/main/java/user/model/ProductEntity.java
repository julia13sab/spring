package user.model;

import lombok.*;
import user.dto.ProductTypeEnum;

import javax.persistence.*;
import java.math.BigDecimal;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "users", schema = "lgc_lgnrn_in")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "account_number")
    private Integer accountNumber;

    @Column(name = "balance")
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private ProductTypeEnum type;
}
