package sda.travelagency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sda.travelagency.model.Shtet;

@Repository
public interface ShtetetRepository extends JpaRepository<Shtet,Long> {

}
