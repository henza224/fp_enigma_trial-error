package saham_ku.saham_ku.Util.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockDTO {
    String name;
    String code;
    Integer price;
}
