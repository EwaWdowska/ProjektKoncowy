package pl.coderslab.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "person_rents")
public class PersonRent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Size(min = 2, max = 50, message = "Nazwisko musi mieć od 2 do 50 znaków")
    private String name;

    @NotBlank
    @Size(min = 2, max = 30, message = "Imię musi mieć od 2 do 30 znaków")
    private String surname;

    @NotBlank(message = "podaj adres wynajmu")
    private String address;

    @Size(min = 9)
    private String numberPhone;

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


    @OneToOne
    private Rent rent;

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
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

    @Size(min = 9)
    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(@Size(min = 9) String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public @Size(min = 2, max = 50, message = "Nazwisko musi mieć od 2 do 50 znaków") String getName() {
        return name;
    }

    public void setName(@Size(min = 2, max = 50, message = "Nazwisko musi mieć od 2 do 50 znaków") String name) {
        this.name = name;
    }

    public @NotBlank @Size(min = 2, max = 30, message = "Imię musi mieć od 2 do 30 znaków") String getSurname() {
        return surname;
    }

    public void setSurname(@NotBlank @Size(min = 2, max = 30, message = "Imię musi mieć od 2 do 30 znaków") String surname) {
        this.surname = surname;
    }
}
