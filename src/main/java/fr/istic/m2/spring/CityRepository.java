package fr.istic.m2.spring;

import fr.istic.m2.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface CityRepository extends JpaRepository<City, Integer> {
    List<City> findAll();

    City findOne(Integer id);

    <S extends City> S save(City city);

    void delete(Integer id);
}
