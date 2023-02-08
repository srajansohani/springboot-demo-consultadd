package abc.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import abc.demo.EmployeeService.*;
import abc.demo.entity.Employee;
import java.util.*;

@RestController
public class myController {
    @Autowired
    public employeeService service;

    // Get request to check data of all employees in db;
    @GetMapping("/home")
    public String home() {
        return "Welcome to Employee Management Sysytem";
    }

    /**
     * @return
     */
    @GetMapping("/Employee")
    public List<Employee> getEmployeeData() {
        return service.getEmployeeData();
    }

    // get request to check for a single employee
    @GetMapping("/Employee/{id}")
    public Employee getEmployeeData(@PathVariable String id) {
        return service.getEmployeeData(Long.parseLong(id));
    }

    // post request handling to add new employee;
    @PostMapping("/Employee")
    public void addEmployee(@RequestBody Employee givenEmployee) {
        service.addEmployee(givenEmployee);
    }

    // put request on path /employee/employeeid to update
    @PutMapping("/Employee/{employeeId}")
    public void updateEmployee(@PathVariable String employeeId, @RequestBody Employee E) {
        service.updateEmployee(Long.parseLong(employeeId), E);
    }

    // delete reuest on path/employee/employeeid

    @DeleteMapping("/Employee/{employeeId}")
    public void deleteEmployee(@PathVariable String emolyeeId) {
        service.deleteEmployee(Long.parseLong(emolyeeId));
    }
}