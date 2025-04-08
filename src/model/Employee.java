package model;

import java.time.LocalDate;

public class Employee extends Person {
    private String position;
    private double salary;
    private final LocalDate hireDate;
    private boolean active;

    public Employee(String name, String cpf, LocalDate birthDate, String position,
                    double salary, LocalDate hireDate, boolean active) {
        super(name, cpf, birthDate);
        this.position = position;
        this.salary = salary;
        this.hireDate = hireDate;
        this.active = active;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                ", cpf='" + this.getCpf() + '\'' +
                ", birthDate=" + this.getBirthDate() +
                ", position='" + this.position + '\'' +
                ", salary=" + this.salary +
                ", hireDate=" + this.hireDate +
                ", active=" + this.active +
                '}';
    }
}
