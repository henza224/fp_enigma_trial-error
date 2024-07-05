package saham_ku.saham_ku.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import saham_ku.saham_ku.model.Portfolio;
import saham_ku.saham_ku.model.User;

public interface PortfolioService {
    Page<Portfolio> getAll(User id,Integer totalAmount, Pageable pageable);
    Portfolio getOne(Integer id);
    Portfolio create(Portfolio req);
    Portfolio update(Integer id,Portfolio req);
    void delete(Integer id);
}
