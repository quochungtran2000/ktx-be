package db.ktx.repository;

import db.ktx.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer > {
	User findByUsername(String username);

	Boolean existByUsername(String username);
}
