package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Flat;
import pl.coderslab.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
