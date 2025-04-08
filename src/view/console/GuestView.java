package view.console;

import controller.PersonController;
import model.people.Guest;

import java.time.LocalDate;
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
                case 1 -> registerGuest();
                case 2 -> listGuests();
                case 0 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção inválida.");
            }
        } while (option != 0);
    }

    private void registerGuest() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Data de nascimento (AAAA-MM-DD): ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());

        LocalDate accountCreationDate = LocalDate.now();
        LocalDate lastReservationDate = LocalDate.now();

        Guest guest = new Guest(name, cpf, birthDate, accountCreationDate, lastReservationDate);
        controller.registerPerson(guest);

        System.out.println("Hóspede cadastrado com sucesso!");
    }

    private void listGuests() {
        System.out.println("\n--- Lista de Hóspedes ---");
        controller.listGuests().forEach(System.out::println);
    }
}
