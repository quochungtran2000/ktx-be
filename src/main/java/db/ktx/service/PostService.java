package db.ktx.service;

import db.ktx.entity.Post;
import db.ktx.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post insertPost(Post post){
          return postRepository.save(post);
    }
    public List<Post> getAllPost(){
        return postRepository.findAll();
    }

    public Post updatePost(Post post){
        Post basePost = postRepository.findById(post.getId()).orElse(null);
        basePost.setTitle(post.getTitle());
        basePost.setContent(post.getContent());
//        basePost.setCategory_id(post.getCategory_id());

        return postRepository.save(basePost);
    }
    public void deleteByTitle(int id){
        postRepository.deleteById(id);
    }


}
