package ru.kutepov.shelter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kutepov.shelter.model.Animal;
import ru.kutepov.shelter.repository.AnimalRepository;
import java.util.List;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> findAll () {
        return animalRepository.findAll();
    }

    public Animal saveAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public void deleteById(Integer id) {
        animalRepository.deleteById(id);
    }

    public Animal findById(Integer id) {
        return animalRepository.findById(id).orElseThrow();
    }

    public List<Animal> findAllNoname() {
        return animalRepository.findAllNoname();
    }



}
