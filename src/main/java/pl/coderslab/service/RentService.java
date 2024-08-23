package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.PersonRent;
import pl.coderslab.entity.Rent;
import pl.coderslab.entity.Room;
import pl.coderslab.repository.PersonRentRepository;
import pl.coderslab.repository.RentRepository;


import java.util.List;
import java.util.Optional;

@Service
public class RentService {

    private final RentRepository rentRepository;

    @Autowired
    public RentService(RentRepository  rentRepository) {
        this.rentRepository = rentRepository;
    }

    public List<Rent> get() {
        return rentRepository.findAll();
    }


    public Optional<Rent> getById (Long id) {
        return rentRepository.findById(id);
    }


    public void save(Rent rent) {
        rentRepository.save(rent);
    }


    public void delete(Long id) {
        rentRepository.deleteById(id);
    }


    public void update (Rent rent ) {
        rentRepository.save(rent);
    }

    public List<Rent> findByPersonRentId(Long personRentId) {
        return rentRepository.findPersonRentById(personRentId);
    }


}
