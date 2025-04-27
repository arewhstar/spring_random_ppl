package ppl.api.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ppl.api.Entity.Person;
import ppl.api.Repository.PersonRepository;
import ppl.api.Service.PersonService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person save(Person personEntity) {
        return personRepository.save(personEntity);
    }

    @Override
    public void saveAll(List<Person> people) {
        personRepository.saveAll(people);
    }

    @Override
    public List<Person> findAll() {
        return StreamSupport.stream(personRepository
                                .findAll()
                                .spliterator(),
                        false)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isExistsByFirstName(String firstname) {
        return personRepository.existsByFirstName(firstname);
    }
}
