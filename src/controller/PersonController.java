package controller;

import model.people.Person;
import model.people.Guest;
import model.people.Employee;
import repository.person.PersonRepositoryHashMap;
import services.Auth;

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
        this.registerPerson(admin);
    }

    public void registerPerson(Person person) {
        repository.add(person);
    }

    public List<Person> listAll() {
        return repository.search();
    }

    public Person findById(UUID id) {
        return repository.searchById(id);
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
        return Auth.login(email, password, repository);
    }
}
