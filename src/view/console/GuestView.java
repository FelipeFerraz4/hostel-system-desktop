package view.console;

import controller.PersonController;

import java.util.Scanner;

public class GuestView {
    private final Scanner scanner;
    private final PersonController controller;

    public GuestView(Scanner scanner, PersonController controller) {
        this.scanner = scanner;
        this.controller = controller;
    }

    public void menu() {
        int option;
        do {
            System.out.println("\n--- MENU DE HÓSPEDES ---");
            System.out.println("1. Cadastrar hóspede");
            System.out.println("2. Listar hóspedes");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 0 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção inválida.");
            }
        } while (option != 0);
    }
}
