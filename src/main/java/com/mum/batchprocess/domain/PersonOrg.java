package com.mum.batchprocess.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
public class PersonOrg {


    private String lastName;
    private String firstName;
    private double gpa;
    private int age;

    public PersonOrg() {

    }

    public PersonOrg(String lastName, String firstName, double gpa, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.gpa = gpa;
        this.age = age;
    }

    @Override
    public String toString() {
        return "firstName: " + firstName + ", lastName: " + lastName;
    }

}