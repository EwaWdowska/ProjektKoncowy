package pl.coderslab.entity;

import javax.validation.constraints.NotBlank;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cleaning")
public class Cleaning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String statusClean;

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

    public String getStatusClean() {
        return statusClean;
    }

    public void setStatusClean(String statusClean) {
        this.statusClean = statusClean;
    }
}
