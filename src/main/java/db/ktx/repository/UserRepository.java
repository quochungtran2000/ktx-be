package db.ktx.repository;

import db.ktx.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long > {
	/**
	 * Find user by username
	 * @param username
	 * @return
	 */
	Optional<User> findByUsername(String username);

	/**
	 * Delete user by username
	 * @param username
	 * @return
	 */
	User deleteByUsername(String username);
}
