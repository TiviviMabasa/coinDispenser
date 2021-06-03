package com.example.demo.model.entities;

import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="item")
@Data
@NoArgsConstructor
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Setter
    @Getter
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    @Getter
    @Column(name="name")
    private String name;

    @Setter
    @Getter
    @Column(name="price")
    private double price;

}
