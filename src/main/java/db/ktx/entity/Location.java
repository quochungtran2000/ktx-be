package db.ktx.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="Location")
@Data
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String location_address;
    private boolean is_public ;

}
