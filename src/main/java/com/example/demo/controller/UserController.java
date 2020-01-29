package com.example.demo.controller;

import com.example.demo.Service.EmployeeService;
import com.example.demo.model.Employee;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "userInformation", description = "operation related user controller")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private EmployeeService employeeService;

    @ApiImplicitParams({
        @ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string",
        paramType = "header")
    })
    @GetMapping("/getAll")
    @ApiOperation(value = "View list of All employees", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public List<Employee> find(){

        return employeeService.getEmployeeList();
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string",
                    paramType = "header")
    })
    @GetMapping("/findById/{id}")
    @ApiOperation(value = "View employee based on Id", response = Employee.class)
    public Employee findById(@PathVariable("id") Integer id){

        return employeeService.findById(id);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string",
                    paramType = "header")
    })
    @GetMapping("/findByName/{name}")
    @ApiOperation(value = "View employee based on Id", response = Employee.class)
    public Employee findByName(@PathVariable("name") String name){

        return employeeService.findByName(name);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string",
                    paramType = "header")
    })
    @GetMapping("/getByNameEmail")
    @ApiOperation(value = "View employee based on Id", response = Employee.class)
    public List<Employee> getByNameEmail(@RequestParam("name") String name, @RequestParam("email") String email){

        return employeeService.getByNameEmail(name, email);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string",
                    paramType = "header")
    })
    @PostMapping("/save")
    @ApiOperation(value = "Save employee", response = Employee.class)
    public Employee save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }
}
