package ppl.api.Repository;


import ppl.api.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    boolean existsByFirstName(String firstName);
}