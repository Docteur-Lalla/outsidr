package fr.istic.m2.spring;

import fr.istic.m2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface UserRepository extends JpaRepository<User, Integer>{
    List<User> findAll();

    User findOne(Integer id);

    User save(User loc);

    void delete(Integer id);

}
