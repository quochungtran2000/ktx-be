package db.ktx.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name ="category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int Categoryid;
    private String catename;
    private int priority;
    private int level;
    private int parentid;
    private String descriptions;

}
