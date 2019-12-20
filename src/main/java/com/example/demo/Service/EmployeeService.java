package com.example.demo.Service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public List<Employee> getEmployeeList(){

        List<Employee> empList = new ArrayList<>();
        employeeDao.findAll().forEach(empList::add);
        return empList;
    }

    public Employee findById(Integer id){

        return employeeDao.findById(id).orElse(null);
    }
    public Employee save(Employee employee){

        return employeeDao.save(employee);
    }

    public void delete(Integer id){
        employeeDao.deleteById(id);
    }

    public Employee findByName(String name) {
       return employeeDao.findByName(name);
    }

    public List<Employee> getByNameEmail(String name, String emial) {
        return employeeDao.getByNameEmail(name, emial);
    }

}

