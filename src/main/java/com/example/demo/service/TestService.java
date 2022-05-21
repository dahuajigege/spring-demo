package com.example.demo.service;

import com.example.demo.entity.People;
import com.example.demo.mapper.PeopleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    private PeopleMapper peopleMapper;

    public void addPeople(People people) {
        peopleMapper.insert(people);
    }

    public List<People> getAllPeople() {
        return peopleMapper.selectByExample(null);
    }
}
