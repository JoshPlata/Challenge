package com.josue.sample.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode
@ToString
@Table(name = "Hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String name;
    private String description;
    private int stars;

    @OneToMany(mappedBy = "hotel", orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Room> room;
}
