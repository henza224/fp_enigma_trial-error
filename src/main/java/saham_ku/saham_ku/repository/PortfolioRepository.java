package saham_ku.saham_ku.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import saham_ku.saham_ku.model.Portfolio;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Integer>, JpaSpecificationExecutor<Portfolio> {
}
