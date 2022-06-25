package sda.travelagency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sda.travelagency.model.Package;

@Repository
public interface PackagesRepository extends JpaRepository<Package,Long> {

}
