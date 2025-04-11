package view.console;

import controller.PersonController;
import model.people.Employee;
import model.people.Guest;
import model.people.Person;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;

public class EmployeeView {
    private final Scanner scanner;
    private final PersonController controller;

    public EmployeeView(Scanner scanner, PersonController controller) {
        this.scanner = scanner;
        this.controller = controller;
    }

    public void menu() {
        int option;
        do {
            System.out.println("\n=== MENU DE FUNCIONÁRIOS ===");
            System.out.println("1. Cadastrar funcionário");
            System.out.println("2. Cadastrar hóspede");
            System.out.println("3. Listar funcionários");
            System.out.println("4. Listar hóspedes");
            System.out.println("5. Atualizar funcionário");
            System.out.println("6. Atualizar hóspede");
            System.out.println("7. Buscar pessoa");
            System.out.println("8. Inativar pessoa");
            System.out.println("0. Voltar");
            System.out.print("Escolha a opção: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> registerEmployee();
                case 2 -> registerGuest();
                case 3 -> listEmployees();
                case 4 -> listGuests();
                case 5 -> updateEmployee();
                case 6 -> updateGuest();
                case 7 -> findPerson();
                case 8 -> deletePerson();
                case 0 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção inválida.");
            }
        } while (option != 0);
    }

    private void registerEmployee() {
        System.out.print("Nome: ");
        String name = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Telefone: ");
        String phone = scanner.nextLine();

        System.out.print("Data de Nascimento (AAAA-MM-DD): ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());

        System.out.print("Cargo: ");
        String position = scanner.nextLine();

        System.out.print("Salario: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        System.out.print("Senha: ");
        String password = scanner.nextLine();

        LocalDate hireDate = LocalDate.now();

        controller.registerEmployee(name, cpf, birthDate, email, password, phone, position, salary, hireDate);

        System.out.println("Funcionário cadastrado com sucesso!");
    }

    private void registerGuest() {
        System.out.print("Nome: ");
        String name = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Data de nascimento (AAAA-MM-DD): ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());

        System.out.print("Telefone: ");
        String phone = scanner.nextLine();

        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        System.out.print("Senha: ");
        String password = scanner.nextLine();

        LocalDate accountCreationDate = LocalDate.now();
        LocalDate lastReservationDate = LocalDate.now();

        controller.registerGuest(name, cpf, birthDate, email, password, phone, accountCreationDate, lastReservationDate);

        System.out.println("Hóspede cadastrado com sucesso!");
    }

    private void listEmployees() {
        System.out.println("\n--- Lista de Funcionários ---");
        controller.listEmployees().forEach(System.out::println);
    }

    private void listGuests() {
        System.out.println("\n--- Lista de Hóspedes ---");
        controller.listGuests().forEach(System.out::println);
    }

    private void updateEmployee() {
        System.out.print("ID do funcionário a atualizar: ");
        UUID id = UUID.fromString(scanner.nextLine());

        Person person = controller.findById(id);
        if (person instanceof Employee employee) {
            System.out.print("Novo telefone: ");
            String phone = scanner.nextLine();

            System.out.print("Novo cargo: ");
            String position = scanner.nextLine();

            System.out.print("Novo salário: ");
            double salary = scanner.nextDouble();
            scanner.nextLine();

            employee.setPhone(phone);
            employee.setPosition(position);
            employee.setSalary(salary);

            controller.updatePerson(employee);
            System.out.println("Funcionário atualizado com sucesso!");
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    private void updateGuest() {
        System.out.print("ID do hóspede a atualizar: ");
        UUID id = UUID.fromString(scanner.nextLine());

        Person person = controller.findById(id);
        if (person instanceof Guest guest) {
            System.out.print("Novo telefone: ");
            String phone = scanner.nextLine();

            guest.setPhone(phone);
            guest.setLastReservationDate(LocalDate.now());

            controller.updatePerson(guest);
            System.out.println("Hóspede atualizado com sucesso!");
        } else {
            System.out.println("Hóspede não encontrado.");
        }
    }

    private void findPerson() {
        System.out.print("ID da pessoa: ");
        UUID id = UUID.fromString(scanner.nextLine());

        Person person = controller.findById(id);
        if (person != null && person.getStatus()) {
            System.out.println("Pessoa encontrada:\n" + person);
        } else {
            System.out.println("Pessoa não encontrada ou inativa.");
        }
    }

    private void deletePerson() {
        System.out.print("ID da pessoa para inativar: ");
        UUID id = UUID.fromString(scanner.nextLine());

        controller.deletePerson(id);
        System.out.println("Pessoa inativada com sucesso.");
    }
}
