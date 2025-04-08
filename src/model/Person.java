package model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public abstract class Person {
    private final UUID id;
    private String name;
    private String cpf;
    private LocalDate birthDate;

    protected Person(String name, String cpf, LocalDate birthDate) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.cpf = cpf;
        this.birthDate = birthDate;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", cpf='" + this.cpf + '\'' +
                ", birthDate=" + this.birthDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
