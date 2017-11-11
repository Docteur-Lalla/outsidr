package fr.istic.m2.spring;

import fr.istic.m2.entities.Activity;
import fr.istic.m2.entities.Registration;
import fr.istic.m2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface RegistrationRepository extends JpaRepository<Registration, Integer>{
    List<Registration> findAll();

    Registration findOne(Integer id);

    Registration findByUser(User user);

    Registration findByActivity(Activity activity);

    Registration save(Registration loc);

    void delete(Integer id);
}
