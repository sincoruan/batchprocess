package com.mum.batchprocess.process;

import com.mum.batchprocess.domain.Person;
import com.mum.batchprocess.domain.PersonOrg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;

public class PersonItemProcessor implements ItemProcessor<PersonOrg, Person> {

    private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

    @Override
    public Person process(final PersonOrg person) throws Exception {
        final String firstName = person.getFirstName().toUpperCase();
        final String lastName = person.getLastName().toUpperCase();
        final double gpa = person.getGpa();
        final LocalDate dob = LocalDate.now().minusYears( person.getAge());

        final Person transformedPerson = new Person(firstName, lastName,gpa,dob);

        log.info("Converting (" + person + ") into (" + transformedPerson + ")");

        return transformedPerson;
    }

}