package saham_ku.saham_ku.utils.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PortfolioDetailDTO {
    private Integer portfolio_id;
    private Integer stock_id;
}
