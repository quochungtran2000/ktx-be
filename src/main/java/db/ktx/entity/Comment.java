package db.ktx.entity;



import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cmt_id;
    private String content;
    private Date time;

    @ManyToOne
    @JoinColumn(name = "post", nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private User user;

    public Comment(){

    }

    public int getId() {
        return cmt_id;
    }

    public void setId(int id) {
        this.cmt_id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
