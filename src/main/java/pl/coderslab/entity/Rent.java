package pl.coderslab.entity;

import javax.validation.constraints.*;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "rents")
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Data rozpoczęcia najmu jest wymagana")
    private String dateStartRent;

    @NotNull(message = "Data rozpoczęcia najmu jest wymagana")
    private String dateEndRent;

    @Min(value = 0, message = "Kwota kaucji nie może być ujemna")
    private double deposit;

    @Min(value = 0, message = "Kwota czynszu nie może być ujemna")
    private double rentPrice;


    private boolean payDeposit;


    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    public @NotNull(message = "Data rozpoczęcia najmu jest wymagana") String getDateEndRent() {
        return dateEndRent;
    }

    public void setDateEndRent(@NotNull(message = "Data rozpoczęcia najmu jest wymagana") String dateEndRent) {
        this.dateEndRent = dateEndRent;
    }

    public @NotNull(message = "Data rozpoczęcia najmu jest wymagana") String getDateStartRent() {
        return dateStartRent;
    }

    public void setDateStartRent(@NotNull(message = "Data rozpoczęcia najmu jest wymagana") String dateStartRent) {
        this.dateStartRent = dateStartRent;
    }

    @Min(value = 0, message = "Kwota kaucji nie może być ujemna")
    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(@Min(value = 0, message = "Kwota kaucji nie może być ujemna") double deposit) {
        this.deposit = deposit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPayDeposit() {
        return payDeposit;
    }

    public void setPayDeposit(boolean payDeposit) {
        this.payDeposit = payDeposit;
    }

    @Min(value = 0, message = "Kwota czynszu nie może być ujemna")
    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(@Min(value = 0, message = "Kwota czynszu nie może być ujemna") double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
