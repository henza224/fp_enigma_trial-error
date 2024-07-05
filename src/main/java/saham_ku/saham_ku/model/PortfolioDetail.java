package project.saham_ku.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "port_details")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class PortfolioDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;

    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;

    private Integer price;

    @Column(name = "quantity_lot")
    private Integer quantity;
}


