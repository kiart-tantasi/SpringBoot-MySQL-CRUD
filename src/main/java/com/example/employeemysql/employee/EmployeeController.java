package com.example.employeemysql.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @PostMapping
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @DeleteMapping(path = "{id}")
    public void deleteEmployee (@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
    }

    @PutMapping(path = "{id}")
    public void updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
        employeeService.updateEmployee(id, employee);
    }


}
