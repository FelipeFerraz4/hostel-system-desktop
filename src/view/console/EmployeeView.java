package view.console;

import controller.PersonController;
import model.people.Employee;

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
            System.out.println("\n--- MENU DE FUNCIONÁRIOS ---");
            System.out.println("1. Cadastrar funcionário");
            System.out.println("2. Listar funcionários");
            System.out.println("0. Voltar");
            System.out.print("Escolha a opção: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> registerEmployee();
                case 2 -> listEmployees();
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

        boolean active = true;

        Employee employee = new Employee(name, cpf, birthDate, email, password, phone, position, salary, hireDate, active);
        controller.registerPerson(employee);

        System.out.println("Funcionário cadastrado com sucesso!");
    }

    private void listEmployees() {
        System.out.println("\n--- Lista de Funcionários ---");
        controller.listEmployees().forEach(System.out::println);
    }
}