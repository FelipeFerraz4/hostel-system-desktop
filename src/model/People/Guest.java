package model.People;

import java.time.LocalDate;

public class Guest extends Person {
    private int reservationCount;
    private final LocalDate accountCreationDate;
    private LocalDate lastReservationDate;

    public Guest(
            String name,
            String cpf,
            LocalDate birthDate,
            int reservationCount,
            LocalDate accountCreationDate,
            LocalDate lastReservationDate) {
        super(name, cpf, birthDate);
        this.reservationCount = reservationCount;
        this.accountCreationDate = accountCreationDate;
        this.lastReservationDate = lastReservationDate;
    }

    public int getReservationCount() {
        return reservationCount;
    }

    public void setReservationCount(int reservationCount) {
        this.reservationCount = reservationCount;
    }

    public LocalDate getAccountCreationDate() {
        return accountCreationDate;
    }

    public LocalDate getLastReservationDate() {
        return lastReservationDate;
    }

    public void setLastReservationDate(LocalDate lastReservationDate) {
        this.lastReservationDate = lastReservationDate;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                ", cpf='" + this.getCpf() + '\'' +
                ", birthDate=" + this.getBirthDate() +
                ", reservationCount=" + this.reservationCount +
                ", accountCreationDate=" + this.accountCreationDate +
                ", lastReservationDate=" + this.lastReservationDate +
                '}';
    }
}
