package ppl.api.Service;


import ppl.api.Entity.Person;

import java.util.List;

public interface PersonService {
    Person save(Person person);

    void saveAll(List<Person> people);

    List<Person> findAll();

    boolean isExistsByFirstName(String firstName);
}
