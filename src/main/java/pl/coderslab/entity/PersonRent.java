package pl.coderslab.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "person_rents")
public class PersonRent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(3)
    @Size(min = 2, max = 50, message = "Nazwisko musi mieć od 2 do 50 znaków")
    private String name;

    @NotBlank
    @Size(min = 2, max = 30, message = "Imię musi mieć od 2 do 30 znaków")
    private String surname;

    @NotBlank(message = "podaj adres wynajmu")
    private String address;

    @Size(min = 9)
    private int numberPhone;

    @Email
    private String email;

    private String moreInformation;

    @OneToOne
    private Flat flat;

    public Flat getFlat() {
        return flat;
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
    }

    @ManyToMany
    private List<Rent> rent;

    public List<Rent> getRent() {
        return rent;
    }

    public void setRent(List<Rent> rent) {
        this.rent = rent;
    }





    public @NotBlank(message = "podaj adres wynajmu") String getAddress() {
        return address;
    }

    public void setAddress(@NotBlank(message = "podaj adres wynajmu") String address) {
        this.address = address;
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMoreInformation() {
        return moreInformation;
    }

    public void setMoreInformation(String moreInformation) {
        this.moreInformation = moreInformation;
    }

    public @Min(3) String getName() {
        return name;
    }

    public void setName(@Min(3) String name) {
        this.name = name;
    }

    @Size(min = 9)
    public int getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(@Size(min = 9) int numberPhone) {
        this.numberPhone = numberPhone;
    }

    public @NotBlank @Min(3) String getSurname() {
        return surname;
    }

    public void setSurname(@NotBlank @Min(3) String surname) {
        this.surname = surname;
    }
}
