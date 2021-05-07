package db.ktx.entity;



import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;

    @ManyToOne()
    @JoinColumn(name = "user", nullable = false)
    private User user;

    @ManyToOne()
    @JoinColumn(name = "category", nullable = false)
    private Category category;

    @ManyToOne()
    @JoinColumn(name = "location", nullable = false)
    private Location location;

    @JsonIgnore
    @OneToMany(mappedBy = "post")
    List<Comment> listComment = new ArrayList<>();

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
    @JsonCreator
    public Post(@JsonProperty("id") int id,@JsonProperty("title") String title, @JsonProperty("content") String content,
                @JsonProperty("user") User user,@JsonProperty("category") Category category,
                @JsonProperty("location") Location location){
        this.id = id;
        this.title = title;
        this.content = content;
        this.category = category;
        this.location = location;
        this.user = user;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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



}