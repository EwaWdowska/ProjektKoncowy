package pl.coderslab.entity;

import javax.validation.constraints.NotBlank;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "rent_Prices")
public class RentPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String statusPay;

    @NotBlank
    private LocalDate date;

    @OneToOne
    @JoinColumn(name = "rent_id")
    private Rent rent;

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    public @NotBlank LocalDate getDate() {
        return date;
    }

    public void setDate(@NotBlank LocalDate date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatusPay() {
        return statusPay;
    }

    public void setStatusPay(String statusPay) {
        this.statusPay = statusPay;
    }
}
