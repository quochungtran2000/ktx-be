package db.ktx.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postid;
    private String title;
    private String content;

    @ManyToOne()
    @JoinColumn(name = "username", nullable = false)
    private User user;

    @ManyToOne()
    @JoinColumn(name = "category_name", nullable = false)
    private Category category;

//    @ManyToOne()
//    @JoinColumn(name = "location_name", nullable = false)
//    private Location location;

    @JsonIgnore
    @OneToMany(mappedBy = "post")
    List<Comment> listComment;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Comment> getListComment() {
        return listComment;
    }

    public void setListComment(List<Comment> listComment) {
        this.listComment = listComment;
    }

    public Post(){

    }


//    public Post( String title, String content, Category category_id, Location location_id, User userid){
//        this.title = title;
//        this.content = content;
//        this.category = category_id;
//        this.location = location_id;
//        this.user = userid;
//
//    }

    public int getId() {
        return postid;
    }

    public void setId(int id) {
        this.postid = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUserid() {
        return user;
    }

    public void setUserid(User userid) {
        this.user  = userid;
    }


//    public Location getLocation_id() {
//        return location;
//    }
//
//    public void setLocation_id(Location location_id) {
//        this.location = location_id;
//    }
}
