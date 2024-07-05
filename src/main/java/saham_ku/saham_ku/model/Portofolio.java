package saham_ku.saham_ku.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "/portofofios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Portofolio {

    private Integer id;

}
