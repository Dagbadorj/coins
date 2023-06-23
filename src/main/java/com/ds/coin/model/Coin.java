package com.ds.coin.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(schema = "S25", name = "bank")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Coin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "origin")
    private String origin;
}
