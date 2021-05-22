package db.ktx.service;

import db.ktx.entity.Comment;
import db.ktx.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository repository;

    public Comment createComment(Comment comment){
        Date now = new Date();
        comment.setTime(now);
        return repository.save(comment);
    }

    public List<Comment> getComment(Comment comment){

        return repository.findAll();
    }

    public Optional<Comment> getCommentById(int id){

        return repository.findById(id);
    }

    public Comment updateComment(Comment comment){
        Comment updateCmt = repository.findById(comment.getId()).orElse(null);
        updateCmt.setContent(comment.getContent());
        return repository.save(comment);
    }


    public void deleteComment(int id){
        repository.deleteById(id);
    }
}
