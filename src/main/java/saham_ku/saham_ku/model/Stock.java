package saham_ku.saham_ku.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "stocks")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String code;
    private Integer price;
}


