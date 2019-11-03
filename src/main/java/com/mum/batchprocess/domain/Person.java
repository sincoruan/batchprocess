package com.mum.batchprocess.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity()
@Table(name="PEOPLE")
@Setter
@Getter
public class Person {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long person_id;
    @Column
    private String lastName;
    @Column
    private String firstName;
    @Column
    private double gpa;
    @Column
    private LocalDate dob;

    public Person() {

    }

    public Person(String lastName, String firstName, double gpa, LocalDate dob) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.gpa = gpa;
        this.dob = dob;
    }
    public Person(String lastName, String firstName, double gpa) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "firstName: " + firstName + ", lastName: " + lastName;
    }

}