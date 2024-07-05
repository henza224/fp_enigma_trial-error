package saham_ku.saham_ku.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "portfolios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "total_amount")
    private Integer totalAmount;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}


