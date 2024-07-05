package saham_ku.saham_ku.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import saham_ku.saham_ku.model.Portfolio;
import saham_ku.saham_ku.model.PortfolioDetail;
import saham_ku.saham_ku.model.Stock;
import saham_ku.saham_ku.repository.PortfolioDetailRepository;
import saham_ku.saham_ku.service.PortfolioDetailService;
import saham_ku.saham_ku.service.PortfolioService;
import saham_ku.saham_ku.utils.DTO.PortfolioDetailDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PortfolioDetailServiceImpl implements PortfolioDetailService {
    private final PortfolioDetailRepository portDetail;
    private final PortfolioService portfolioService;
//    private final StockService stockService;

    @Override
    public PortfolioDetail create(PortfolioDetailDTO req) {
        Portfolio portfolio = portfolioService.getOne(req.getPortfolio_id());
//        Stock stock = stockService.getOne(req.getStock_id());

        PortfolioDetail portfolioDetail= new PortfolioDetail();
        portfolioDetail.setPortfolio(portfolio);

        return portDetail.save(portfolioDetail);
    }

    @Override
    public List<PortfolioDetail> getAll() {
        return portDetail.findAll();
    }

    @Override
    public PortfolioDetail getOne(Integer id) {
        return portDetail.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
    }
}
