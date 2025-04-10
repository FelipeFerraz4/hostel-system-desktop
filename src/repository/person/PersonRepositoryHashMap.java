package repository.person;

import interfaces.IRepository;
import model.people.Person;

import java.util.*;

public class PersonRepositoryHashMap implements IRepository<Person> {
    private final Map<UUID, Person> storage = new HashMap<>();

    @Override
    public void add(Person person) {
        storage.put(person.getId(), person);
    }

    @Override
    public List<Person> search() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public Person searchById(UUID id) {
        return storage.get(id);
    }

    @Override
    public void update(Person person) {
        UUID id = person.getId();
        if (storage.containsKey(id)) {
            storage.put(id, person);
        }
    }

    @Override
    public void delete(UUID id) {
        Person person = storage.get(id);
        if (person != null) {
            person.setStatus(false);
        }
    }

    public List<Person> getByType(Class<?> clazz) {
        List<Person> result = new ArrayList<>();
        for (Person p : storage.values()) {
            if (clazz.isInstance(p)) {
                result.add(p);
            }
        }
        return result;
    }
}
