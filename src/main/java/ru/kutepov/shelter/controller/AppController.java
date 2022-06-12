package ru.kutepov.shelter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kutepov.shelter.model.Animal;
import ru.kutepov.shelter.service.AnimalService;
import ru.kutepov.shelter.service.TypeService;
import java.util.List;

@Controller
public class AppController {
    private final AnimalService animalService;
    private final TypeService typeService;

    @Autowired
    public AppController(AnimalService animalService, TypeService typeService) {
        this.animalService = animalService;
        this.typeService = typeService;
    }

    @GetMapping("/animals")
    public String findAll(Model model) {
        List<Animal> animals = animalService.findAll();
        model.addAttribute("animals", animals);
        return "animal-list";
    }

    @GetMapping("/animal-create")
    public String createAnimalForm(Animal animal) {
        return "animal-create";
    }

    @PostMapping("/animal-create")
    String createAnimal(Animal animal) {
        animalService.saveAnimal(animal);
        return "redirect:/animals";
    }

    @GetMapping("/animal-delete/{id}")
    public String deleteAnimal(@PathVariable("id") Integer id) {
        animalService.deleteById(id);
        return "redirect:/animals";
    }

    @GetMapping("/animal-update/{id}")
    public String updateAnimalForm(@PathVariable("id") Integer id, Model model){
        Animal animal = animalService.findById(id);
        model.addAttribute("animal", animal);
        return "animal-update";
    }

    @PostMapping("/animal-update")
    public String updateAnimal(Animal animal){
        animalService.saveAnimal(animal);
        return "redirect:/animals";
    }

    @GetMapping("/noname-animals")
    public String findAllNoname(Model model) {
        List<Animal> animals = animalService.findAllNoname();
        model.addAttribute("animals", animals);
        return "animal-noname-list";
    }
}
