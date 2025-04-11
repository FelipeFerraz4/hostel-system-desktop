package controller;

import model.people.Person;
import model.people.Guest;
import model.people.Employee;
import repository.person.PersonRepositoryHashMap;
import services.AuthServices;
import services.UserServices;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class PersonController {
    private final PersonRepositoryHashMap repository;

    public PersonController() {
        this.repository = new PersonRepositoryHashMap();
        Employee admin = new Employee(
                "admin",
                "99988833300",
                LocalDate.parse("2000-01-01"),
                "admin@gmail.com",
                "123456",
                "",
                "Gerente",
                15000,
                LocalDate.parse("2015-06-06"));
        this.repository.add(admin);
    }

    public void registerGuest(
            String name,
            String cpf,
            LocalDate birthDate,
            String email,
            String password,
            String phone,
            LocalDate accountCreationDate,
            LocalDate lastReservationDate) {
        UserServices.RegistreGuest(name, cpf, birthDate, email, password, phone, accountCreationDate, lastReservationDate, repository);
    }

    public void registerEmployee(
            String name,
            String cpf,
            LocalDate birthDate,
            String email,
            String password,
            String phone,
            String position,
            double salary,
            LocalDate hireDate){
        UserServices.RegistreEmployee(name, cpf, birthDate, email, password, phone, position, salary, hireDate, repository);
    }

    public List<Person> listAll() {
        return repository.search();
    }

    public Person findById(UUID id) {
        return repository.searchById(id);
    }

    public Person findByName(String name){
        return repository.searchByName(name);
    }

    public Person findByCPF(String cpf){
        return repository.searchByCpf(cpf);
    }

    public Person findByEmail(String email){
        return repository.searchByEmail(email);
    }

    public void updatePerson(Person updatedPerson) {
        repository.update(updatedPerson);
    }

    public void deletePerson(UUID id) {
        repository.delete(id);
    }

    public List<Person> listGuests() {
        return repository.getByType(Guest.class);
    }

    public List<Person> listEmployees() {
        return repository.getByType(Employee.class);
    }

    public Person login(String email, String password){
        return AuthServices.login(email, password, repository);
    }
}
