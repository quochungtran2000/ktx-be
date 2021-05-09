package db.ktx.controller;


import db.ktx.entity.Category;
import db.ktx.entity.Location;
import db.ktx.entity.Post;
import db.ktx.entity.User;
import db.ktx.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class PostController {

    @Autowired
    public PostService postService;

//    @GetMapping("/post")
//    public List<Post> getAllPost(){
//
//        return postService.getAllPost();
//    }
    @GetMapping("/id/{id}")
    public Optional<Post> getById(@PathVariable("id")  int id){
        return postService.getById(id);
    }

    @GetMapping("/post")
    @ResponseBody
    public List<Post> getByLocation(@RequestParam("location") Location id){
        return postService.getPostByLocation(id);
    }
    @GetMapping("/post1")
    @ResponseBody
    public List<Post> getByLocationAndCategory(@RequestParam("location") Location location, @RequestParam("category")
                                               Category category){
        return postService.getPostByLocationAndCategory(location, category);
    }

    @GetMapping("/post2")
    @ResponseBody
    public List<Post> getByUser(@RequestParam("user")User user){
        return postService.getPostByUser(user);
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
