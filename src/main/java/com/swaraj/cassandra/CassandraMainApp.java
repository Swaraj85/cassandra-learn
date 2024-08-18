package com.swaraj.cassandra;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class CassandraMainApp implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(CassandraMainApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.debug("debug: jholer");
        log.info("command line app started");
    }
}