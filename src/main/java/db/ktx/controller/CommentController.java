package db.ktx.controller;

import db.ktx.entity.Comment;
import db.ktx.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cmt")
public class CommentController {

    @Autowired
    private  CommentService service;

    @GetMapping("/comment")
    public List<Comment> viewAllComment(Comment comment){
        return service.getComment(comment);
    }

    @GetMapping(path = "{id}")
    public Optional<Comment> getCmtById(@PathVariable("id") int id){
        return service.getCommentById(id);
    }

    @PostMapping("/comment")
    public Comment creatCmt(@Validated @RequestBody Comment comment){
        return service.createComment(comment);
    }

    @PutMapping("/comment")
    public String putCmt(@Validated @RequestBody Comment comment){
        return service.updateComment(comment);
    }

    @DeleteMapping(path = "{id}")
    public String deleteCmnt(@PathVariable("id") int id ){
        service.deleteComment(id);
        return "Xoa Thanh Cong";
    }
}
