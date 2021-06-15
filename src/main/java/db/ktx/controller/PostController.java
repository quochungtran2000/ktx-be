package db.ktx.controller;
import db.ktx.entity.Category;
import db.ktx.entity.Location;
import db.ktx.entity.Post;
import db.ktx.entity.User;
import db.ktx.repository.PostRepository;
import db.ktx.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/post")
public class  PostController {

    @Autowired
    public PostService postService;

    @Autowired
    private PostRepository repository;

    @GetMapping()
    @ResponseBody
    public ResponseEntity<?>getByLocationAndCategory(
            @RequestParam(value= "location", required = false) Location location,
            @RequestParam(value = "category",required = false) Category category,
            @RequestParam(name = "page" , required = false, defaultValue = "1") int page,
            @RequestParam(name = "size", required = false, defaultValue = "12") int size,
            @RequestParam(name = "user", required = false)User user
    ){
        System.out.print(location);
        System.out.print(category);
        try{
            List<Post> posts = new ArrayList<Post>();
            Pageable pageable = PageRequest.of(page-1,size);
            Page<Post> pageTuts ;

            if(location == null && category == null && user == null){
                pageTuts = repository.findPost(pageable);

            }
            else if(location != null && category !=null && user == null){
                pageTuts = repository.findByLocationAndCategory(location,category,pageable);
            }
            else{
                if(user != null){
                    pageTuts = repository.findByUser(user, pageable);
                }else
                if(location != null){
                    pageTuts = repository.findByLocation(location, pageable);
                }
                else{
                    pageTuts = repository.findByCategory(category, pageable);
                }
            }

            posts = pageTuts.getContent();
            Map<String, Object> response = new HashMap<>();
            response.put("post", posts);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public Optional<Post> getById(@PathVariable("id")  int id){
        return postService.getById(id);
    }

    @PostMapping()
    public Post createPost(@RequestBody Post post){
        return  postService.insertPost(post);
    }

    @PutMapping( )
    public Post updatePost(@RequestBody Post post){
        return postService.updatePost(post);
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable("id") int id){
        postService.deleteByTitle(id);
        return "Xoa thanh cong";
    }
}
