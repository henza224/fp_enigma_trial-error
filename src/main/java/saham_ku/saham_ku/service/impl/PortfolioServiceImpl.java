package saham_ku.saham_ku.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import saham_ku.saham_ku.model.Portfolio;
import saham_ku.saham_ku.model.User;
import saham_ku.saham_ku.repository.PortfolioRepository;
import saham_ku.saham_ku.service.PortfolioService;
import saham_ku.saham_ku.utils.specification.PortfolioSpecification;

@Service
@RequiredArgsConstructor
public class PortfolioServiceImpl implements PortfolioService {
    private final PortfolioRepository portRepo;

    @Override
    public Page<Portfolio> getAll(User id,Integer totalAmount, Pageable pageable) {
        Specification<Portfolio> spec = PortfolioSpecification.getSpecification(id,totalAmount);
        return portRepo.findAll(spec,pageable);
    }

    @Override
    public Portfolio getOne(Integer id) {
        return portRepo.findById(id).orElseThrow(() -> new  RuntimeException("Not Found"));
    }

    @Override
    public Portfolio create(Portfolio req) {
        return portRepo.save(req);
    }

    @Override
    public Portfolio update(Integer id, Portfolio req) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        portRepo.deleteById(id);
    }
}
