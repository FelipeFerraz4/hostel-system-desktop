package services;

import interfaces.IRepository;
import model.people.Employee;
import model.people.Guest;
import model.people.Person;

import java.time.LocalDate;

public class UserServices {

    public static void RegistreGuest(
            String name,
            String cpf,
            LocalDate birthDate,
            String email,
            String password,
            String phone,
            LocalDate accountCreationDate,
            LocalDate lastReservationDate,
            IRepository<Person> repository) {
        Guest guest = new Guest(name, cpf, birthDate, email, password, phone, accountCreationDate, lastReservationDate);
        repository.add(guest);
    }

    public static void RegistreEmployee(
            String name,
            String cpf,
            LocalDate birthDate,
            String email,
            String password,
            String phone,
            String position,
            double salary,
            LocalDate hireDate,
            IRepository<Person> repository) {
        Employee employee = new Employee(name, cpf, birthDate, email, password, phone, position, salary, hireDate);
        repository.add(employee);
    }
}
