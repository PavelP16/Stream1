package com.skypro.stream1.controller;

import com.skypro.stream1.controller.model.Employee;
import com.skypro.stream1.controller.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping("{deptId}/salary/sum")
    public double sumByDept(@PathVariable int deptId) {
        return service.sum(deptId);
    }

    @GetMapping("{deptId}/salary/max")
    public Employee max(@PathVariable int deptId) {
        return service.maxSalary(deptId);
    }

    @GetMapping("{deptId}/salary/min")
    public Employee min(@PathVariable int deptId) {
        return service.minSalary(deptId);
    }

    @GetMapping("{deptId}/employees")
    public List<Employee> find(@PathVariable int deptId) {
        return service.findAllByDept(deptId);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> group() {
        return service.groupDeDept();
    }
}