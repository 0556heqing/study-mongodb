package com.heqing.mongodb.repository;

import com.heqing.mongodb.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author heqing
 * @date 2021/10/28
 */
@Repository
public interface PersonExtRepository extends MongoRepository<Person, Long>  {

    /**
     * 根据名字查找
     * @param name
     * @return
     */
    List<Person> findByName(String name);

    /**
     * 根据名字查找（自定义实现）
     * @param name
     * @return
     */
    @Query("{ 'name' : ?#{[0]} }")
    List<Person> findPersonByName(@Param("name") String name);
}
