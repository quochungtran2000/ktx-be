package db.ktx.controller;


import db.ktx.entity.Post;
import db.ktx.repository.PostRepository;
import db.ktx.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post")
@CrossOrigin(origins = "*" , maxAge = 3600)
public class PostController {

    @Autowired
    public PostService postService;

    @GetMapping("/getAllPost")
    public List<Post> getAllPost(){

        return postService.getAllPost();
    }

    @PostMapping("/createPost")
    public Post createPost(@Validated @RequestBody Post post){
        return  postService.insertPost(post);
    }

    @PutMapping("/update")
    public Post updatePost(@RequestBody Post post){
        return postService.updatePost(post);
    }

    @DeleteMapping(path = "{id}")
    public String deletePost(@PathVariable("id") int id){
        postService.deleteByTitle(id);
        return "Xoa thanh cong";
    }
}
