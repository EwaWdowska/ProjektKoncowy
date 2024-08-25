package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Rent;

import java.util.List;

@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {

    List<Rent> findRentById(Long personRentId);



}
