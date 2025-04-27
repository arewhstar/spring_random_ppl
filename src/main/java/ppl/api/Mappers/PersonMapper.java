package ppl.api.Mappers;

import ppl.api.DTO.PersonDTO;
import ppl.api.Entity.Person;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper implements Mapper<Person, PersonDTO>{

    private ModelMapper modelMapper;

    public PersonMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public PersonDTO mapTo(Person person) {
        return modelMapper.map(person, PersonDTO.class);
    }

    @Override
    public Person mapFrom(PersonDTO personDTO) {
        return modelMapper.map(personDTO, Person.class);
    }
}
