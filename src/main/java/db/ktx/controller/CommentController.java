package db.ktx.controller;

import db.ktx.entity.Comment;
import db.ktx.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private  CommentService service;

    @GetMapping("/")
    public List<Comment> viewAllComment(Comment comment){
        return service.getComment(comment);
    }

    @GetMapping("/{id}")
    public Optional<Comment> getCmtById(@PathVariable("id") int id){
        return service.getCommentById(id);
    }

    @PostMapping("/")
    public Comment createCmt(@Validated @RequestBody Comment comment){
        return service.createComment(comment);
    }

    @PutMapping("/")
    public Comment putCmt( @RequestBody Comment comment){
        return service.updateComment(comment);
    }


    @DeleteMapping("/{id}")
    public String deleteCmt(@PathVariable("id") int id ){
        service.deleteComment(id);
        return "Xoa Thanh Cong";
    }
}
