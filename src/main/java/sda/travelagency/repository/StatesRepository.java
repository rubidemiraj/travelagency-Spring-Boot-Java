package sda.travelagency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sda.travelagency.model.States;

@Repository
public interface StatesRepository extends JpaRepository<States,String> {

}
