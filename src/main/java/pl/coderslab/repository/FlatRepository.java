package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Flat;


@Repository
public interface FlatRepository extends JpaRepository<Flat, Long> {
}
