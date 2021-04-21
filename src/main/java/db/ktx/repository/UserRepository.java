package db.ktx.repository;

import db.ktx.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Integer > {
	/**
	 * Find user by user name
	 * @param username
	 * @return
	 */
	Optional<User> findByUsername(String username);

	/**
	 * Check exists an user by user name
	 * @param username
	 * @return
	 */
	Boolean existsByUsername(String username);

	/**
	 * Check exists an user email
	 * @param email
	 * @return
	 */
	Boolean existsByEmail(String email);
}
