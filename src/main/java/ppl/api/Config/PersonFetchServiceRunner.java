package ppl.api.Config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ppl.api.Service.impl.PersonFetchServiceImpl;

@Component
public class PersonFetchServiceRunner implements ApplicationRunner{
    private final PersonFetchServiceImpl personFetchServiceImpl;

    @Value("${NATIONALITY:us}")
    private String nationality;

    public PersonFetchServiceRunner(PersonFetchServiceImpl personFetchServiceImpl) {
        this.personFetchServiceImpl = personFetchServiceImpl;
    }

    @Override
    public void run(ApplicationArguments args) {
        System.out.println("Fetching people with nationality: " + nationality);
        personFetchServiceImpl.fetchAndSavePeople(nationality);
    }
}
