package view.console;

import controller.PersonController;

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
            System.out.println("1. Menu de Hóspedes");
            System.out.println("2. Menu de Funcionários");
            System.out.println("0. Sair");
            System.out.print("Escolha a opção: ");
            option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1 -> guestView.menu();
                case 2 -> employeeView.menu();
                case 0 -> System.out.println("Saindo do sistema. Até logo!");
                default -> System.out.println("Opção inválida.");
            }
        } while (option != 0);
    }
}
