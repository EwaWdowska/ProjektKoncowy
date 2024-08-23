package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.Flat;
import pl.coderslab.repository.FlatRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JpaFlatService {

    private final FlatRepository flatRepository;

    @Autowired
    public JpaFlatService(FlatRepository flatRepository) {
        this.flatRepository = flatRepository;
    }

    public List<Flat> getF() {
        return flatRepository.findAll();
    }


    public Optional<Flat> getByIdF (Long id) {
        return flatRepository.findById(id);
    }


    public void saveF(Flat flat) {
        flatRepository.save(flat);
    }


    public void deleteF(Long id) {
        flatRepository.deleteById(id);
    }


    public void updateF (Flat flat) {
        flatRepository.save(flat);
    }

}

