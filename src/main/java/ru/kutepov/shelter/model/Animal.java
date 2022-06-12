package ru.kutepov.shelter.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "_list")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Animal implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    private String name;

    private int weight;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private Type animalByTypeId;

    public Animal(String name, int weight, Type animalByTypeId) {
        this.name = name;
        this.weight = weight;
        this.animalByTypeId = animalByTypeId;
    }
}
