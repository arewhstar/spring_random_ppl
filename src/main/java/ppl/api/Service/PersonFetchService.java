package ppl.api.Service;

import ppl.api.Entity.Person;

import java.util.List;

public interface PersonFetchService
{
    List<Person> fetchAndSavePeople(String nationality);
}
