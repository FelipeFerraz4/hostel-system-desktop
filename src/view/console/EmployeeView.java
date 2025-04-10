package view.console;

import controller.PersonController;
import model.people.Employee;
import model.people.Guest;

import java.time.LocalDate;
import java.util.Scanner;

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
            System.out.println("0. Voltar");
            System.out.print("Escolha a opção: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> registerEmployee();
                case 2 -> registerGuest();
                case 3 -> listEmployees();
                case 4 -> listGuests();
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

        Employee employee = new Employee(name, cpf, birthDate, email, password, phone, position, salary, hireDate);
        controller.registerPerson(employee);

        System.out.println("Funcionário cadastrado com sucesso!");
    }

    private void registerGuest() {
        System.out.print("Name: ");
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

        Guest guest = new Guest(name, cpf, birthDate, email, password, phone, accountCreationDate, lastReservationDate);
        controller.registerPerson(guest);

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
}