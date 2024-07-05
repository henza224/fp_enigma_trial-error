package saham_ku.saham_ku.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import saham_ku.saham_ku.model.User;

public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
}
