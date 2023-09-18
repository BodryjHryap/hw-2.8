package pro.sky.hw28.service;

import pro.sky.hw28.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {

    Employee employeeWithMaxSalary(Integer departmentId);

    Employee employeeWithMinSalary(Integer departmentId);

    Collection<Employee> getAllEmployee(Integer departmentId);

    Map<Integer, List<Employee>> getEmployee();

}
