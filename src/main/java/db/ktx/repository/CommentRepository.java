package db.ktx.repository;

import db.ktx.entity.Comment;
import db.ktx.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment , Integer> {

    @Query("select u from Comment u where u.post = ?1")
    List<Comment> getCommentByPost(Post post);

}
