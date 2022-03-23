package com.example.employeemysql.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public void addEmployee(Employee employee) {
        if (employee.getName() == null || employee.getPosition() == null || employee.getAge() < 1) throw new IllegalStateException("Missing some information");
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {

        Employee existingEmployee = employeeRepository.findById(id)
                        .orElseThrow(() -> new IllegalStateException("no employee with id " + id.toString() + " found"));
        employeeRepository.deleteById(id);
    }

}
