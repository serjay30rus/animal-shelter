package ru.kutepov.shelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kutepov.shelter.model.Animal;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    @Query(value = "SELECT _list.id, _list.name, _list.weight, _list.type_id FROM _list JOIN _type ON _list.type_id = _type.id WHERE type = 'STRAY'", nativeQuery = true)
    List<Animal> findAllNoname();
}
