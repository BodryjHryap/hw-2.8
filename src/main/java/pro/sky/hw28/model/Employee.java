package pro.sky.hw28.model;

import java.util.Objects;
import java.util.Random;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final int department;
    private int salary;


    public Employee(String firstName, String lastName) {
        Random random = new Random();
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = random.nextInt(2) + 1;
        this.salary = random.nextInt(10000) + 1000;
    }
    public String getLastName() {
        return lastName;
    }

    public String getFisrtName() {
        return firstName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() !=o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    public String toString() {
        return "Имя: " + firstName + ". Фамилия: " + lastName;
    }

    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
