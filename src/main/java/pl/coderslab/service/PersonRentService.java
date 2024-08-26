package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.PersonRent;
import pl.coderslab.entity.Rent;
import pl.coderslab.entity.Room;
import pl.coderslab.repository.PersonRentRepository;
import pl.coderslab.repository.RoomRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonRentService {

    private final PersonRentRepository personRentRepository;

    @Autowired
    public PersonRentService(PersonRentRepository  roomRepository) {
        this.personRentRepository = roomRepository;
    }

    public List<PersonRent> get() {
        return personRentRepository.findAll();
    }


    public Optional<PersonRent> getById (Long id) {
        return personRentRepository.findById(id);
    }


    public void save(PersonRent personRent) {
        personRentRepository.save(personRent);
    }


    public void delete(Long id) {
        personRentRepository.deleteById(id);
    }


    public void update (PersonRent personRent) {
        personRentRepository.save(personRent);
    }


    public List<PersonRent> findPersonRentById(Long  flatId) {
        return personRentRepository.findPersonRentById(flatId);
    }



}
