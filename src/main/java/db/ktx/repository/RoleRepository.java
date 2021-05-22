package db.ktx.repository;

import db.ktx.entity.Role;
import db.ktx.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role , Integer> {
    Role findByName (Roles name);

}
