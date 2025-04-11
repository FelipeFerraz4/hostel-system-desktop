package view.console;

import controller.PersonController;
import model.people.Person;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleMenu {
    private final Scanner scanner = new Scanner(System.in);
    private final PersonController controller = new PersonController();
    private final GuestView guestView = new GuestView(scanner, controller);
    private final EmployeeView employeeView = new EmployeeView(scanner, controller);

    public void start() {
        int option;
        do {
            System.out.println("\n==== SISTEMA DE POUSADA ====");
            System.out.println("1. Fazer login");
            System.out.println("2. Criar novo usuário");
            System.out.println("0. Sair");
            System.out.print("Escolha a opção: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> login();
                case 2 -> registerGuest();
                case 0 -> System.out.println("Saindo do sistema. Até logo!");
                default -> System.out.println("Opção inválida.");
            }
        } while (option != 0);
    }

    private void login() {
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String password = scanner.nextLine();

        Person user = controller.login(email, password);
        if (user == null) {
            System.out.println("Credenciais inválidas.");
            return;
        }

        System.out.println("Login realizado com sucesso! Bem-vindo(a), " + user.getName() + ".");

        if (user instanceof model.people.Guest) {
            guestView.menu();
        } else if (user instanceof model.people.Employee) {
            employeeView.menu();
        } else {
            System.out.println("Tipo de usuário desconhecido.");
        }
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

        controller.registerGuest(name, cpf, birthDate, email, password, phone, accountCreationDate, lastReservationDate);

        System.out.println("Hóspede cadastrado com sucesso!");
    }
}
