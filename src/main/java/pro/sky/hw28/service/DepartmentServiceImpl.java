package pro.sky.hw28.service;

import org.springframework.stereotype.Service;
import pro.sky.hw28.exceptions.EmployeeNotFoundException;
import pro.sky.hw28.model.Employee;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee employeeWithMaxSalary(Integer departmentId) {
        return employeeService.getAllEmployees()
                .stream()
                .filter(e -> e.getDepartment() == departmentId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(()-> new EmployeeNotFoundException("Сотрудники не найдены"));
    }

    @Override
    public Employee employeeWithMinSalary(Integer departmentId) {
        return employeeService.getAllEmployees()
                .stream()
                .filter(e -> e.getDepartment() == departmentId)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(()-> new EmployeeNotFoundException("Сотрудники не найдены"));
    }

    @Override
    public Collection<Employee> getAllEmployee(Integer departmentId) {
        return employeeService.getAllEmployees()
                .stream()
                .filter(e -> e.getDepartment() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getEmployee() {
        return employeeService.getAllEmployees()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
