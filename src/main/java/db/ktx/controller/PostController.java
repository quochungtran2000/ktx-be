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

    @GetMapping("/post")
    @ResponseBody
    public List<Post> getByLocationAndCategory(@RequestParam(value= "location", required = false) Location location, @RequestParam(value = "category",required = false)
            Category category){
        System.out.print(location);
        System.out.print(category);
        List<Post> data = null;
        if(location == null && category == null){
            data = postService.getAllPost();
        }
        else if(location != null && category != null){
            data = postService.getPostByLocationAndCategory(location, category);
        }else{
            if(location != null){
                data = postService.getPostByLocation(location);
            }else{
                data = postService.getPostByCategory(category);
            }
        }
        return data;
    }


    @GetMapping("/post/{id}")
    public Optional<Post> getById(@PathVariable("id")  int id){
        return postService.getById(id);
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
