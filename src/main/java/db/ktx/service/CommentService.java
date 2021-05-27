package db.ktx.service;

import db.ktx.entity.Comment;
import db.ktx.entity.User;
import db.ktx.repository.CommentRepository;
import db.ktx.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository repository;

    @Autowired
    private UserRepository userRepository;

    public String createComment(Comment comment){
        if(comment.getContent() ==  null) {
                return "Comment must not be empty";

        }
        Date now = new Date();
        comment.setTime(now);
        repository.save(comment);
        return "Add comment successfully !";
    }

    public List<Comment> getComment(Comment comment){

        return repository.findAll();
    }

    public Optional<Comment> getCommentById(int id){

        return repository.findById(id);
    }
//
//    public Comment updateComment(Comment comment){
//        Comment updateCmt = repository.findById(comment.getId()).orElse(null);
//        updateCmt.setContent(comment.getContent());
//        return repository.save(updateCmt);
//
//    }


    public void deleteComment(int id){
        repository.deleteById(id);
    }
}
