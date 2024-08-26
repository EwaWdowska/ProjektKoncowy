package pl.coderslab.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Min(1)
    private Long numberRoom;

    @NotBlank
    @Min(0)
    private Long areaRoom;

    @ManyToOne
    @JoinColumn(name = "flat_id")
    private Flat flat;

    public Flat getFlat() {
        return flat;
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
    }

    public Room() {
    }

    public Room(Long areaRoom, Flat flat, Long id, Long numberRoom) {
        this.areaRoom = areaRoom;
        this.flat = flat;
        this.id = id;
        this.numberRoom = numberRoom;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAreaRoom() {
        return areaRoom;
    }

    public void setAreaRoom(Long areaRoom) {
        this.areaRoom = areaRoom;
    }

    public Long getNumberRoom() {
        return numberRoom;
    }

    public void setNumberRoom(Long numberRoom) {
        this.numberRoom = numberRoom;
    }
}
