package fr.istic.m2.spring;

import fr.istic.m2.entities.Meteo;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface MeteoRepository extends JpaRepository<Meteo, Integer> {
  List<Meteo> findAll();

  Meteo findOne(Integer id);

  Meteo save(Meteo meteo);
}
