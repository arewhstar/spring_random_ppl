package ppl.api.Service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import ppl.api.Entity.Person;
import ppl.api.Service.PersonFetchService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonFetchServiceImpl implements PersonFetchService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final PersonServiceImpl personServiceImpl;

    public PersonFetchServiceImpl(PersonServiceImpl personServiceImpl) {
        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();
        this.personServiceImpl = personServiceImpl;
    }

    @Override
    public List<Person> fetchAndSavePeople(String nationality) {
        String API_URL = String.format("https://randomuser.me/api/?results=100&nat=%s", nationality);
        List<Person> peopleList = new ArrayList<>();

        try {
            String jsonResponse = restTemplate.getForObject(API_URL, String.class);
            JsonNode root = objectMapper.readTree(jsonResponse);
            JsonNode results = root.path("results");

            peopleList = parsePeople(results);

            System.out.println("Fetched from API: " + API_URL);

        } catch (Exception e) {
            System.err.println("API fetch failed: " + e.getMessage());
            System.out.println("Loading dummy data from resources...");

            // Load from local dummy JSON
            try {
                String dummyFileName = "dummy_data_"+nationality.toLowerCase()+".json";

                InputStream inputStream = getClass()
                        .getClassLoader()
                        .getResourceAsStream(dummyFileName);

                if (inputStream == null) {
                    throw new RuntimeException("Dummy JSON file not found: " + dummyFileName);
                }

                JsonNode root = objectMapper.readTree(inputStream);
                JsonNode results = root.path("results");

                peopleList = parsePeople(results);

            } catch (Exception ex) {
                System.err.println("Error loading dummy data: " + ex.getMessage());
            }
        }

        // Save all to database
        personServiceImpl.saveAll(peopleList);

        return peopleList;
    }

    private List<Person> parsePeople(JsonNode resultsNode) {
        List<Person> people = new ArrayList<>();

        for (JsonNode personNode : resultsNode) {
            Person person = new Person();
            person.setFirstName(personNode.path("name").path("first").asText());
            person.setLastName(personNode.path("name").path("last").asText());
            person.setEmail(personNode.path("email").asText());
            person.setNationality(personNode.path("nat").asText());
            people.add(person);
        }

        return people;
    }

}