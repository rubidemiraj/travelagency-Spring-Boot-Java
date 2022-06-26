package sda.travelagency.Service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.travelagency.model.Package;
import sda.travelagency.repository.PackagesRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PackagesService implements IPackagesService{


    private PackagesRepository packagesRepository;

    @Override
    public List<Package> getAllPackages() {
        return packagesRepository.findAll();
    }

    @Override
    public void savePackage(Package pakete) {
        this.packagesRepository.save(pakete);
    }

    @Override
    public Package getPackageById(long id) {
        Optional<Package> optional = packagesRepository.findById(id);
        Package pakete = null;
        if (optional.isPresent()) {
            pakete = optional.get();
        } else {
            throw new RuntimeException(" Paketa e kerkuar nuk u gjet :: " + id);
        }
        return pakete;
    }

    @Override
    public void deletePackageById(long id) {
        this.packagesRepository.deleteById(id);
    }
}
