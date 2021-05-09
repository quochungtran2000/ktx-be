package db.ktx.service;

import db.ktx.entity.Category;
import db.ktx.entity.Location;
import db.ktx.entity.Post;
import db.ktx.entity.User;
import db.ktx.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post insertPost(Post post){
          return  postRepository.save(post);

    }
    public Optional<Post> getById(int id){
        return postRepository.findById(id);
    }
    public List<Post> getAllPost(){
        return postRepository.findAll();
    }

    public Post updatePost(Post post){
        Post basePost = postRepository.findById(post.getId()).orElse(null);
        basePost.setTitle(post.getTitle());
        basePost.setContent(post.getContent());
//      asePost.setCategory_id(post.getCategory_id());

        return postRepository.save(basePost);
    }
    public void deleteByTitle(int id){
        postRepository.deleteById(id);
    }

    //getPostByLocation
    public List<Post> getPostByLocation(Location location){
        return postRepository.getPostByLocation(location);
    }

    //getPostByLocationAndCategory
    public List<Post> getPostByLocationAndCategory(Location location, Category category){
        return postRepository.getPostByLocationAndCategory(location,category);
    }

    //getPostByUser
    public List<Post> getPostByUser(User user){
        return postRepository.getPostByUser(user);
    }

}
