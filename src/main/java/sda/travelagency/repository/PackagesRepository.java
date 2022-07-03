package sda.travelagency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sda.travelagency.dto.PackageFilter;
import sda.travelagency.model.Country;
import sda.travelagency.model.Package;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PackagesRepository extends JpaRepository<Package, UUID> {
    @Query("from Package p left join fetch p.country c  where :query is null or lower(p.title) like %:query% or lower(c.title) like %:query% ")
    List<Package> filter(@Param("query") String query);

    @Query("from Package p left join fetch p.country c  where lower(c.title) like %:query% ")
    List<Package> findByCountry(@Param("query") String query);

    @Query("from Package  p where p.title = :title")
    Optional<Package> findByTitle(@Param("title") String title);


}
