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
//@CrossOrigin
public class CommentController {

    @Autowired
    private  CommentService service;

    @GetMapping("/comment")
    public List<Comment> viewAllComment(Comment comment){
        return service.getComment(comment);
    }

    @GetMapping("/id/{id}")
    public Optional<Comment> getCmtById(@PathVariable("id") int id){
        return service.getCommentById(id);
    }

    @PostMapping("/createComment")
    public Comment createCmt(@Validated @RequestBody Comment comment){
        return service.createComment(comment);
    }

    @PutMapping("/update")
    public Comment putCmt( @RequestBody Comment comment){
        return service.updateComment(comment);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteCmt(@PathVariable("id") int id ){
        service.deleteComment(id);
        return "Xoa Thanh Cong";
    }
}
