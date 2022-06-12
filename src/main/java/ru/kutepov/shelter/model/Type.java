package ru.kutepov.shelter.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Type implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('PET', 'STRAY')", name = "type")
    private AnimalType animalType;

    @OneToMany(mappedBy = "animalByTypeId")
    private Collection<Animal> animals;

    public Type(AnimalType animalType) {
        this.animalType = animalType;
    }
}
