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


    @Size(max = 10)
    private LocalDate dateStartRent;


    @Size(max = 10)
    @Future
    private LocalDate dateEndRent;

    @NotBlank
    @Min(0)
    private double deposit;

    @NotBlank
    @Min(0)
    private double rentPrice;

    @NotBlank
    @AssertTrue
    private boolean payDeposit;


    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }






    public @Size(max = 10) @Future LocalDate getDateEndRent() {
        return dateEndRent;
    }

    public void setDateEndRent(@Size(max = 10) @Future LocalDate dateEndRent) {
        this.dateEndRent = dateEndRent;
    }

    public @Size(max = 10) LocalDate getDateStartRent() {
        return dateStartRent;
    }

    public void setDateStartRent(@Size(max = 10) LocalDate dateStartRent) {
        this.dateStartRent = dateStartRent;
    }

    @NotBlank
    @Min(0)
    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(@NotBlank @Min(0) double deposit) {
        this.deposit = deposit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotBlank
    @AssertTrue
    public boolean isPayDeposit() {
        return payDeposit;
    }

    public void setPayDeposit(@NotBlank @AssertTrue boolean payDeposit) {
        this.payDeposit = payDeposit;
    }

    @NotBlank
    @Min(0)
    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(@NotBlank @Min(0) double rentPrice) {
        this.rentPrice = rentPrice;
    }
}
