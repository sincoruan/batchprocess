package com.mum.batchprocess.repository;

import com.mum.batchprocess.domain.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Person, Long> {
    @Override
    Iterable<Person> findAll();
}
