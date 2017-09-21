package fr.istic.m2.spring;

import fr.istic.m2.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ActivityRepository extends JpaRepository<Activity, Integer> {
    List<Activity> findAll();

    Activity findOne(Integer id);

    Activity save(Activity act);
}
