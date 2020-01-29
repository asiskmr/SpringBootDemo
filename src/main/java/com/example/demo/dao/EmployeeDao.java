package com.example.demo.dao;

import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {

    Employee findByName(String name);

    @Query("SELECT e FROM Employee e WHERE e.name=:name and e.email=:email")
    List<Employee> getByNameEmail(@Param("name") String name, @Param("email") String email);
}
