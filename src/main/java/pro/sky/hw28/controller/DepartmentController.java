package pro.sky.hw28.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.hw28.model.Employee;
import pro.sky.hw28.service.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping("/max-salary")
    public Employee employeeWithMaxSalary(@RequestParam Integer departmentId) {
        return departmentService.employeeWithMaxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee employeeWithMinSalary(@RequestParam Integer departmentId) {
        return departmentService.employeeWithMinSalary(departmentId);
    }

    @GetMapping(value = "/allEmployees", params = {"departmentId"})   // Маппинг должен быть однозначным
    public Collection<Employee> getEmployees(@RequestParam Integer departmentId) {
        return departmentService.getAllEmployee(departmentId);
    }

    @GetMapping("/allEmployees")
    public Map<Integer, List<Employee>> getEmployees() {
        return departmentService.getEmployee();
    }
}
