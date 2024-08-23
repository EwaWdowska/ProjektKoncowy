package pl.coderslab.entity;


import org.hibernate.validator.constraints.Range;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name="flats")
public class Flat {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @NotBlank(message = "Miejscowość jest wymagana")
    @Column(nullable = false)
    @Size(min = 2, max = 50, message = "Miasto musi mieć od 2 do 50 znaków")
    private String city;

    @NotBlank(message = "Ulica jest wymagana")
    @Column(nullable = false)
    @Size(min = 2, max = 50, message = "Ulica musi mieć od 2 do 50 znaków")
    private String street;

    @NotBlank(message = "Numer budynku jest wymagany")
    @Size(min=1)
    @Column(nullable = false)
    private String numberBuild;

    @Min(value = 0, message = "numer mieszkania musi być liczbą dodatnią")
    private int numberFlat;


    @Min(value = 1, message = "Ilość pokoi musi wynosić co najmniej 1")
    @Column(nullable = false)
    private int quantityRoom;


    public Flat() {
    }

    public Flat(String city, Long id, String numberBuild, int numberFlat, int quantityRoom, String street) {
        this.city = city;
        this.id = id;
        this.numberBuild = numberBuild;
        this.numberFlat = numberFlat;
        this.quantityRoom = quantityRoom;
        this.street = street;
    }

    public @NotBlank(message = "Miejscowość jest wymagana") @Size(min = 2, max = 50, message = "Miasto musi mieć od 2 do 50 znaków") String getCity() {
        return city;
    }

    public void setCity(@NotBlank(message = "Miejscowość jest wymagana") @Size(min = 2, max = 50, message = "Miasto musi mieć od 2 do 50 znaków") String city) {
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Numer budynku jest wymagany") @Size(min = 1) String getNumberBuild() {
        return numberBuild;
    }

    public void setNumberBuild(@NotBlank(message = "Numer budynku jest wymagany") @Size(min = 1) String numberBuild) {
        this.numberBuild = numberBuild;
    }

    @Min(value = 0, message = "numer mieszkania musi być liczbą dodatnią")
    public int getNumberFlat() {
        return numberFlat;
    }

    public void setNumberFlat(@Min(value = 0, message = "numer mieszkania musi być liczbą dodatnią") int numberFlat) {
        this.numberFlat = numberFlat;
    }

    @Min(value = 1, message = "Ilość pokoi musi wynosić co najmniej 1")
    public int getQuantityRoom() {
        return quantityRoom;
    }

    public void setQuantityRoom(@Min(value = 1, message = "Ilość pokoi musi wynosić co najmniej 1") int quantityRoom) {
        this.quantityRoom = quantityRoom;
    }

    public @NotBlank(message = "Ulica jest wymagana") @Size(min = 2, max = 50, message = "Ulica musi mieć od 2 do 50 znaków") String getStreet() {
        return street;
    }

    public void setStreet(@NotBlank(message = "Ulica jest wymagana") @Size(min = 2, max = 50, message = "Ulica musi mieć od 2 do 50 znaków") String street) {
        this.street = street;
    }
}
