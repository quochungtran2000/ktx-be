package db.ktx.repository;

import db.ktx.ERole;
import db.ktx.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(ERole rolename);
}
