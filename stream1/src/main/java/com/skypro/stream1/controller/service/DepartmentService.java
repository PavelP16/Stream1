package com.skypro.stream1.controller.service;

import com.skypro.stream1.controller.exceptions.EmployeeNotFoundException;
import com.skypro.stream1.controller.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final List<Employee> employees;

    public DepartmentService(List<Employee> employees) {
        this.employees = employees;
    }

    public double sum(int departmentId) {
        return employees.stream()
                .filter(e -> e.getDepartment() == departmentId)
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    public Employee maxSalary(int departmentId) {
        return employees.stream()
                .filter(e -> e.getDepartment() == departmentId)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник с максимальной зарплатой не найден"));
    }

    public Employee minSalary(int departmentId) {
        return employees.stream()
                .filter(e -> e.getDepartment() == departmentId)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник с минимальной зарплатой не найден"));
    }

    public List<Employee> findAllByDept(int departmentId) {
        return employees.stream()
                .filter(e -> e.getDepartment() == departmentId)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> groupDeDept() {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}