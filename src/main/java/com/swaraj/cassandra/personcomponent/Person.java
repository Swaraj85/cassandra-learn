package com.swaraj.cassandra.personcomponent;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import lombok.Data;

@Data
@Table("person")
public class Person {

    @PrimaryKey
    private String id;
    private String firstName;
    private String lastName;
    private int age;

    // Constructors, Getters, Setters, etc.
}
