package ppl.api.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ppl.api.DTO.PersonDTO;
import ppl.api.Entity.History;
import ppl.api.Entity.Person;
import ppl.api.Mappers.Mapper;
import ppl.api.Service.impl.HistoryServiceImpl;
import ppl.api.Service.impl.PersonServiceImpl;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping
public class PersonController {

    private final PersonServiceImpl personServiceImpl;
    private final HistoryServiceImpl historyServiceImpl;
    private final Mapper<Person, PersonDTO> personMapper;


    public PersonController(PersonServiceImpl personServiceImpl, HistoryServiceImpl historyServiceImpl,Mapper<Person, PersonDTO> personMapper) {
        this.personServiceImpl = personServiceImpl;
        this.historyServiceImpl = historyServiceImpl;
        this.personMapper = personMapper;

    }

    @GetMapping("/person/{firstname}")
    public ResponseEntity<String> checkPersonExists(@PathVariable String firstname) {

        boolean exists = personServiceImpl.isExistsByFirstName(firstname);

        History history = new History();
        history.setRequest(firstname);
        history.setResponse(Boolean.toString(exists));


        historyServiceImpl.save(history);


        if (!exists) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Person exists", HttpStatus.OK);
    }

    @GetMapping(path = "/people")
    public List<PersonDTO> listPeople() {
        List<Person> people = personServiceImpl.findAll();
        return people.stream()
                .map(personMapper::mapTo)
                .collect(Collectors.toList());
    }
}