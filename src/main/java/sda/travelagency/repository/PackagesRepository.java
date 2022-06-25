package sda.travelagency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sda.travelagency.model.Packages;

@Repository
public interface PackagesRepository extends JpaRepository<Packages,Long> {

}
