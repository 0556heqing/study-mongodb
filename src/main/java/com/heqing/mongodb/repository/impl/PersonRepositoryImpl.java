package com.heqing.mongodb.repository.impl;

import com.heqing.mongodb.model.Person;
import com.heqing.mongodb.repository.PersonRepository;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author heqing
 * @date 2021/10/28
 */
@Repository
public class PersonRepositoryImpl extends BaseRepositoryImpl<Person, Long> implements PersonRepository {

    @Override
    public List<Person> list(Query query) {
        return mongoTemplate.find(query, persistentClass);
    }

    @Override
    public long count(Query query) {
        return mongoTemplate.count(query, persistentClass);
    }

    @Override
    public List<Person> listGroupBy(Aggregation aggregation) {
        AggregationResults<Person> results = mongoTemplate.aggregate(aggregation, collectionName, persistentClass);
        return results.getMappedResults();
    }
}
