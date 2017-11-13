package fr.istic.m2.spring;

import fr.istic.m2.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    List<City> findAll();

    City findByid(Integer id);

    City save(City city);

    void delete(Integer id);

    void deleteAll();
}
