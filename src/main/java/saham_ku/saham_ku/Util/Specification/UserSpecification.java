package saham_ku.saham_ku.Util.Specification;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import saham_ku.saham_ku.Model.User;
import saham_ku.saham_ku.Util.DTO.UserDTO;

import java.util.ArrayList;
import java.util.List;


public class UserSpecification {

    public static Specification<User> getUserSpecification(UserDTO req){
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (req.getUsername()!= null){
                Predicate usernamePredicate = criteriaBuilder.like(
                        root.get("username"), "%" + req.getUsername() + "%"
                );
                predicates.add(usernamePredicate);
            }
            if (req.getBalance()!=null
                    && req.getBalance() > 0
            ){
                Predicate balancePredicate;
                    if (req.getBalance()<= 500_000){
                        balancePredicate =criteriaBuilder.lessThanOrEqualTo(
                                root.get("balance"), 500_000);
                        predicates.add(balancePredicate);
                    } else if (req.getBalance()<= 1_000_000) {
                        balancePredicate = criteriaBuilder.lessThanOrEqualTo(
                                root.get("balance"), 1_000_000);
                        predicates.add(balancePredicate);
                    } else if (req.getBalance()<= 2_000_000) {
                        balancePredicate = criteriaBuilder.lessThanOrEqualTo(
                                root.get("balance"), 2_000_000);
                        predicates.add(balancePredicate);
                    } else if(req.getBalance()<=5_000_000){
                        balancePredicate = criteriaBuilder.lessThanOrEqualTo(
                                root.get("balance"), 5_000_000);
                        predicates.add(balancePredicate);
                }
            }
            if( req.getRole()!= null){
                Predicate rolePredicate =  criteriaBuilder.like(
                        root.get("role"), req.getRole()
                );
                predicates.add(rolePredicate);
            }

            return query.where(predicates.toArray(new Predicate[]{})).getRestriction();
        };

    }

}
