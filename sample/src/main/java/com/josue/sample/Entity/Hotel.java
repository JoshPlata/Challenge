package com.josue.sample.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "Hotel")
public class Hotel {
    @Id
    @Column(name = "id")
    private Long id;
    private String name;
    private String description;
    private double stars;
    @OneToMany(mappedBy = "hotel")
    private Set<Room> room;
}
