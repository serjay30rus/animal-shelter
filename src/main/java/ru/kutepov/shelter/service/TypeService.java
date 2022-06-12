package ru.kutepov.shelter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kutepov.shelter.repository.TypeRepository;

@Service
public class TypeService {
    @Autowired
    TypeRepository typeRepository;
}
