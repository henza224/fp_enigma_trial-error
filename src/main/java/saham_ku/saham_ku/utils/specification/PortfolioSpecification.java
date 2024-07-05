package saham_ku.saham_ku.utils.specification;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import saham_ku.saham_ku.model.Portfolio;
import saham_ku.saham_ku.model.User;

import java.util.ArrayList;
import java.util.List;

public class PortfolioSpecification {
    public static Specification<Portfolio> getSpecification(User id, Integer totalAmount){
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (totalAmount != null && !totalAmount.toString().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("total_amount"),totalAmount));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
