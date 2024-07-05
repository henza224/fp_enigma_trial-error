package saham_ku.saham_ku.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import saham_ku.saham_ku.model.Portfolio;
import saham_ku.saham_ku.model.PortfolioDetail;
import saham_ku.saham_ku.utils.DTO.PortfolioDetailDTO;

import java.util.List;

public interface PortfolioDetailService {
    PortfolioDetail create(PortfolioDetailDTO req);
    List<PortfolioDetail> getAll();
    PortfolioDetail getOne(Integer id);
}
