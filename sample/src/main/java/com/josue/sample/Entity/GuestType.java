package com.josue.sample.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "guest_type")
public class GuestType {
    @Id
    @Column(name = "id")
    private Long id;
    private String name;
    @OneToOne(mappedBy = "type")
    private Guest guest;
}
