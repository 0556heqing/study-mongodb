package com.heqing.mongodb.repository;

import com.heqing.mongodb.model.Person;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * @author heqing
 * @date 2021/10/28
 */
public interface PersonRepository extends BaseRepository<Person, Long> {

    /**
     * 根据条件查找
     * @param query
     * @return
     */
    List<Person> list(Query query);

    /**
     * 根据条件查找条数
     * @param query
     * @return
     */
    long count(Query query);

    /**
     * 分组
     * @param aggregation
     * @return
     */
    List<Person> listGroupBy(Aggregation aggregation);
}
