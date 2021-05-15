package db.ktx.repository;

import db.ktx.entity.Post;
import db.ktx.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long > {
	/**
	 * Find user by username
	 * @param username
	 * @return
	 */
	@Query("select u from User u where u.username = ?1")
	User findByUsername(String username);

	/**
	 * Delete user by username
	 * @param username
	 * @return
	 */
	User deleteByUsername(String username);

	@Query("select u from User u")
	Page<User> findUser(Pageable pageable);
}
