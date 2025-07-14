package user.model;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@Table(name = "users", schema = "lgc_lgnrn_in")
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "username")
    private String userName;

    @OneToMany(mappedBy = "user")
    private List<ProductEntity> products;

}
