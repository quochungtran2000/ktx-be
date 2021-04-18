package db.ktx.entity;

import db.ktx.ERole;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name ="role")
@Data
public class Role{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    @Column(length  = 20)
    private ERole name;
}
