package ru.kutepov.shelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kutepov.shelter.model.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {
}
