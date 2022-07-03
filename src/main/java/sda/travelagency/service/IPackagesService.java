package sda.travelagency.service;

import sda.travelagency.dto.PackageFilter;
import sda.travelagency.model.Package;

import java.util.List;

public interface IPackagesService {

    List<Package> getAllPackages();
    void savePackage(Package pakete);
    Package getPackageById(String id);
    void deletePackageById(String id);
    List<Package> filter(PackageFilter filter);
    List<Package> findByCountry(String county);
    void createDummyData();
}
