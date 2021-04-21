package db.ktx.repository;

import db.ktx.ERole;
import db.ktx.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    /**
     * Find role by name
     * @param name
     * @return
     */
    Optional<Role> findByName(ERole name);
}
