package db.ktx.repository;

import db.ktx.entity.Category;
import db.ktx.entity.Location;
import db.ktx.entity.Post;
import db.ktx.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post , Integer >{

    @Query("select u from Post u where u.location = ?1")
    List<Post> getPostByLocation(Location location);

    @Query("select u from Post u where u.category = ?1")
    List<Post> getPostByCategory(Category category);

    @Query("select u from Post u where u.location = ?1 and u.category =?2")
    List<Post> getPostByLocationAndCategory(Location location, Category category);

    @Query("select u from Post u where u.user = ?1")
    List<Post>  getPostByUser(User user);

    @Query("select u from Post u order by u.id desc")
    Page<Post> findPost(Pageable pageable);

    Page<Post> findByLocation(Location location, Pageable pageable);

    Page<Post> findByCategory(Category location, Pageable pageable);

    Page<Post> findByLocationAndCategory(Location location,Category category, Pageable pageable);

    Page<Post> findByUser(User user, Pageable pageable);



}
