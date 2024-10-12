package com.swaraj.cassandra.routercomponent;

import com.swaraj.cassandra.personcomponent.Person;
import com.swaraj.cassandra.personcomponent.PersonRepository;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

@Component
public class MyCamelRouter extends RouteBuilder {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void configure() throws Exception {
        // Route to process files from a folder
        from("file:{{camel.route.inbox.dir}}?noop=true") // Monitor the folder for new files
                .log("Processing file: ${file:name}") // Log the file name
                .to("file:{{camel.route.outbox.dir}}"); // Move the processed file to another folder

        from("timer:kafka-producer?period=5000") // Periodic trigger every 5 seconds
                .setBody(simple("Test message at ${date:now}"))
                .log("Sending message to Kafka: ${body}")
                .process(exchange -> {
                    int i = new Random().nextInt(34);
                    log.debug("saving person in cassandra");
                    Person p = new Person();
                    p.setId(UUID.randomUUID().toString());
                    p.setFirstName("swaraj-" + i);
                    p.setAge(i);
                    p.setLastName("ghosh");
                    personRepository.save(p);
                    log.debug("save sucess  in cassandra");
                })
                .to("kafka:{{kafka.topic}}?brokers={{camel.component.kafka.brokers}}");
    }
}
