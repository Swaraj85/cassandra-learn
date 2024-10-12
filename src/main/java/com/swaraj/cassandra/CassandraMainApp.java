package com.swaraj.cassandra;


import com.swaraj.cassandra.personcomponent.Person;
import com.swaraj.cassandra.personcomponent.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class CassandraMainApp implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(CassandraMainApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.debug("saving person in cassandra");
//        Person p = new Person();
//        p.setId("tlc-id");
//        p.setFirstName("swaraj");
//        p.setLastName("ghosh");
//        personRepository.save(p);
        log.debug("save sucess  in cassandra");
        log.info("application init-completed");
    }
}