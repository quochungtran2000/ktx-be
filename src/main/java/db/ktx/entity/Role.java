package db.ktx.entity;


import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private Roles name;

    public Role(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Roles getName() {
        return name;
    }

    public void setName(Roles name) {
        this.name = name;
    }
}
