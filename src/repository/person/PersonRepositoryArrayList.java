package repository.person;

import interfaces.IRepository;
import model.people.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PersonRepositoryArrayList implements IRepository<Person> {
    private final List<Person> people = new ArrayList<>();

    @Override
    public void add(Person person) {
        if (searchById(person.getId()) == null) {
            people.add(person);
        }
    }

    @Override
    public List<Person> search() {
        return new ArrayList<>(people);
    }

    @Override
    public Person searchById(UUID id) {
        for (Person person : people) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public void update(Person updatedPerson) {
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getId().equals(updatedPerson.getId())) {
                people.set(i, updatedPerson);
                return;
            }
        }
    }

    @Override
    public void delete(UUID id) {
        people.removeIf(person -> person.getId().equals(id));
    }

    public List<Person> getByType(Class<?> clazz) {
        List<Person> result = new ArrayList<>();
        for (Person person : people) {
            if (clazz.isInstance(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
