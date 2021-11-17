package com.heqing.mongodb;

import com.heqing.mongodb.config.SpringMongoDBConfig;
import com.heqing.mongodb.model.Person;
import com.heqing.mongodb.repository.PersonExtRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = SpringMongoDBConfig.class
)
public class PeopleExtTest {

    @Autowired
    PersonExtRepository personExtRepository;

    @Test
    public void testList() {
        List<Person> personList =  personExtRepository.findAll();
        personList.forEach(System.out::println);
    }

    @Test
    public void testListByName() {
        List<Person> personList =  personExtRepository.findByName("贺小黑");
        personList.forEach(System.out::println);
    }

    @Test
    public void testFindPersonByName() {
        List<Person> personList =  personExtRepository.findPersonByName("贺小黑");
        personList.forEach(System.out::println);
    }
}
