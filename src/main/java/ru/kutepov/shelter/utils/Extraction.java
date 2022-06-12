package ru.kutepov.shelter.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.kutepov.shelter.model.Animal;
import ru.kutepov.shelter.model.AnimalType;
import ru.kutepov.shelter.model.Type;
import ru.kutepov.shelter.repository.AnimalRepository;
import ru.kutepov.shelter.repository.TypeRepository;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Excel extractor

@Component
public class Extraction {
    final String FILE_NAME = "src\\main\\resources\\data.xlsx";
    private AnimalRepository animalRepository;
    private TypeRepository typeRepository;
    private Map<Integer, Type> typeMap = new HashMap<>();
    private Type type;

    @Autowired
    public Extraction(AnimalRepository animalRepository, TypeRepository typeRepository) {
        this.animalRepository = animalRepository;
        this.typeRepository = typeRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void extracting() {
        String result = "";
        int number;
        XSSFWorkbook workBook = null;

        // Saving Type entities:
        for (int i = 0; i < 2; i++) {
            AnimalType typeAnimal = (i % 2 == 0) ? AnimalType.PET : AnimalType.STRAY;
            Type type = new Type(typeAnimal);
            typeRepository.save(type);
            typeMap.put(i, type);
        }

        try (InputStream inputStream = new FileInputStream(FILE_NAME)){
            workBook = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        XSSFSheet sheet = workBook.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();

        while (it.hasNext()) {
            Row row = it.next();
            Iterator<Cell> cells = row.iterator();
            while (cells.hasNext()) {
                Cell cell = cells.next();
                if (cell.getCellType() == CellType.STRING) {
                    result = cell.getStringCellValue();
                } else if (cell.getCellType() == CellType.NUMERIC) {
                    number = (int) cell.getNumericCellValue();
                    save(result, number);
                }
            }
        }
    }

    //Saving Animals entities
    public void save(String name, int weight) {
        if (name.equals("NoName")) {
            type = typeMap.get(1);
        } else type = typeMap.get(0);
        Animal animal = new Animal(name, weight, type);
        animalRepository.save(animal);
    }

}
