package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.Flat;
import pl.coderslab.entity.Room;
import pl.coderslab.repository.FlatRepository;
import pl.coderslab.repository.RoomRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository  roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> get() {
        return roomRepository.findAll();
    }


    public Optional<Room> getById (Long id) {
        return roomRepository.findById(id);
    }


    public void save(Room room) {
        roomRepository.save(room);
    }


    public void delete(Long id) {
        roomRepository.deleteById(id);
    }


    public void update (Room room) {
        roomRepository.save(room);
    }


}
