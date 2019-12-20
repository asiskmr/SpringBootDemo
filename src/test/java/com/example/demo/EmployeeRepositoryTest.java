package com.example.demo;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJdbcTest
public class EmployeeRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void whenFindByName_thenReturnEmployee() {
        // given
        Employee alex = new Employee(101,"alex","a@b.com");
        entityManager.persist(alex);
        entityManager.flush();

        // when
       // Employee found = employeeDao.findByName(alex.getName());

        // then

    }
}
