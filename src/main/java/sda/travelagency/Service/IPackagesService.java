package sda.travelagency.Service;

import org.springframework.stereotype.Service;
import sda.travelagency.model.Package;

import java.util.List;

public interface IPackagesService {

    List<Package> getAllPackages();
    void savePackage(Package pakete);
    Package getPackageById(long id);
    void deletePackageById(long id);

}
