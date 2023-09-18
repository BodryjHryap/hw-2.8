package pro.sky.hw28.service;

import org.springframework.stereotype.Service;
import pro.sky.hw28.exceptions.EmployeeAlreadyAddedException;
import pro.sky.hw28.exceptions.EmployeeNotFoundException;
import pro.sky.hw28.exceptions.EmployeeStorageIsFullException;
import pro.sky.hw28.model.Employee;

import java.util.*;

@Service
public class EmployeeService {

    private final int maxSize = 9;
    private final Map<String, Employee> employees = new HashMap<>();

    public EmployeeService() {
        add("Ivan", "Ivanov");
        add("Aleksandr", "Aleksandrov");
        add("Denis", "Denisov");
        add("George", "Best");
        add("Diego", "Maradonna");
    }

    public Employee add(String firstName, String lastName) {
        if (employees.size() >= maxSize) {
            throw new EmployeeStorageIsFullException("Достигнут лимит на добавление сотрудников!");
        }

        String key = getKey(firstName, lastName);

        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже был добавлен!");
        }

        Employee employeeAdded = new Employee(firstName, lastName);

        employees.put(key, employeeAdded);
        return employeeAdded;
    }

    public Employee remove(String firstName, String lastName) {
        String key = getKey(firstName, lastName);

        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("Удаляемого Вами сотрудника не существует!");
        }

        Employee employeeRemoved = employees.get(key);

        employees.remove(key);
        return employeeRemoved;
    }

    public Employee find(String firstName, String lastName) {
        String key = getKey(firstName, lastName);

        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("Искомого Вами сотрудника не существует!");
        }

        return employees.get(key);
    }

    public Collection<Employee> getAllEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }

    private String getKey(String firstName, String lastName) {
        return firstName + lastName;
    }
}

