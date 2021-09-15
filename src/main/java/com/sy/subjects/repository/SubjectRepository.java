package com.sy.subjects.repository;

import com.sy.subjects.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    Subject findByName(String name);

    //  https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
    Subject findByNameIgnoreCase(String name);
}
