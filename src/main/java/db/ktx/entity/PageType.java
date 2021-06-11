package db.ktx.entity;

import org.springframework.data.domain.Page;

import javax.persistence.*;

@Entity
@Table(name = "pageType")
public class PageType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @Column(unique = true)
    private staticPageType type;
    private String title;
    private String content;
    private String Description;

    public PageType(){}
    public staticPageType getType() {
        return type;
    }

    public void setType(staticPageType type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
