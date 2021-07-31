package com.josue.sample.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "room_type")
public class RoomType {
    @Id
    @Column(name = "id")
    private Long id;
    private String name;
    @OneToOne(mappedBy = "type")
    private Room room;
}
