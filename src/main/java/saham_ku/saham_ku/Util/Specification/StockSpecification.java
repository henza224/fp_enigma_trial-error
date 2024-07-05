package saham_ku.saham_ku.Util.Specification;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import saham_ku.saham_ku.Model.Stock;
import saham_ku.saham_ku.Util.DTO.StockDTO;

import java.util.ArrayList;
import java.util.List;

public class StockSpecification {
    public static Specification<Stock> getStockSpecification(StockDTO req){
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (req.getName()!= null
            ){
                Predicate namePredicate = criteriaBuilder.like(
                        root.get("name"), "%" + req.getName() + "%"
                );
                predicates.add(namePredicate);
            }
            if(req.getCode() != null
            ){
                Predicate codePredicate = criteriaBuilder.like(
                        root.get("code"), "%" + req.getCode() + "%"
                );
                predicates.add(codePredicate);
            }
            if (req.getPrice() != null
                    && req.getPrice()>0
            ){
                Predicate pricePredicate;
                if (req.getPrice()<=1000){
                    pricePredicate = criteriaBuilder.lessThanOrEqualTo(
                            root.get("price"), 1000);
                } else if (req.getPrice()<=3000) {
                    pricePredicate = criteriaBuilder.lessThanOrEqualTo(
                            root.get("price"), 3000);
                } else if (req.getPrice()<=5000) {
                    pricePredicate = criteriaBuilder.lessThanOrEqualTo(
                            root.get("price"), 5000);
                } else if (req.getPrice()<=10000) {
                    pricePredicate = criteriaBuilder.lessThanOrEqualTo(
                        root.get("price"), 10000);
                } else {
                    pricePredicate = criteriaBuilder.lessThanOrEqualTo(
                            root.get("price"), req.getPrice());
                }
                predicates.add(pricePredicate);
            }
            return query.where(predicates.toArray(new Predicate[]{})).getRestriction();
        };
    }
}
