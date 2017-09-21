package fr.istic.m2.spring;

import fr.istic.m2.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface LocationRepository extends JpaRepository<Location, Integer>{
    List<Location> findAll();

    Location findOne(Integer id);

    Location save(Location loc);

    void delete(Integer id);
}
