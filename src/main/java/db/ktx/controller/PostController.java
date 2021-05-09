package db.ktx.controller;


import db.ktx.entity.Post;
import db.ktx.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    public PostService postService;

    @GetMapping("/getAllPost")
    public List<Post> getAllPost(){

        return postService.getAllPost();
    }
    @GetMapping("/id/{id}")
    public Optional<Post> getById(@PathVariable("id")  int id){
        return postService.getById(id);
    }
    @PostMapping("/createPost")
    public Post createPost(@Validated @RequestBody Post post){
        return  postService.insertPost(post);
    }

    @PutMapping("/update")
    public Post updatePost(@RequestBody Post post){
        return postService.updatePost(post);

    }

    @DeleteMapping("/delete/{id}")
    public String deletePost(@PathVariable("id") int id){
        postService.deleteByTitle(id);
        return "Xoa thanh cong";
    }
}
