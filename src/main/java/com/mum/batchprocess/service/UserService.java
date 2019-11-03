package com.mum.batchprocess.service;

import com.mum.batchprocess.domain.Person;
import com.mum.batchprocess.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public List<Person> getAllPersons(){
        return (List<Person>)userRepository.findAll();
    }
}
