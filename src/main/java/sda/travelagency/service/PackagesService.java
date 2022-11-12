package sda.travelagency.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sda.travelagency.dto.PackageFilter;
import sda.travelagency.model.Country;
import sda.travelagency.model.Package;
import sda.travelagency.repository.CountryRepository;
import sda.travelagency.repository.PackagesRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PackagesService implements IPackagesService {
    private PackagesRepository packagesRepository;
    protected CountryRepository countryRepository;

    @Override
    public List<Package> getAllPackages() {
        return packagesRepository.findAll();
    }

    @Override
    public List<Package> filter(PackageFilter filter) {
        return packagesRepository.filter(filter.getQuery() != null ? filter.getQuery().toLowerCase() : null);
    }

    @Override
    public List<Package> findByCountry(String county) {
        return packagesRepository.findByCountry(county != null ? county.toLowerCase() : null);
    }


    @Override
    public void savePackage(Package pakete) {
        this.packagesRepository.save(pakete);
    }

    @Override
    public Package getPackageById(String id) {
        Optional<Package> optional = packagesRepository.findById(UUID.fromString(id));
        Package pakete = null;
        if (optional.isPresent()) {
            pakete = optional.get();
        } else {
            throw new RuntimeException(" Paketa e kerkuar nuk u gjet :: " + id);
        }
        return pakete;
    }

    @Override
    public void deletePackageById(String  id) {
        this.packagesRepository.deleteById(UUID.fromString(id));
    }

    @Override
    public void createDummyData() {
        Optional<Country> albania = countryRepository.findByTitle("Shqiperi");
        if (albania.isEmpty()) {
            Country c = Country.builder().title("Shqiperi").build();
            countryRepository.save(c);
            albania = Optional.ofNullable(c);
        }

        Optional<Country> turqi = countryRepository.findByTitle("Turqi");
        if (turqi.isEmpty()) {
            Country c = Country.builder().title("Turqi").build();
            countryRepository.save(c);
            turqi = Optional.ofNullable(c);
        }

        Optional<Country> itali = countryRepository.findByTitle("Itali");
        if (itali.isEmpty()) {
            Country c = Country.builder().title("Itali").build();
            countryRepository.save(c);
            itali = Optional.ofNullable(c);
        }

        Optional<Country> greqi = countryRepository.findByTitle("Greqi");
        if (greqi.isEmpty()) {
            Country c = Country.builder().title("Greqi").build();
            countryRepository.save(c);
            greqi = Optional.ofNullable(c);
        }


        Optional<Package> stamboll  = packagesRepository.findByTitle("Stamboll");
        if (stamboll.isEmpty()) {
            Package p = Package.builder()
                    .departureTime("15/07/2022")
                    .returnTime("19/07/2022")
                    .title("Stamboll")
                    .description("")
                    .price(120f)
                    .duration(4)
                    .imageSrc("")
                    .location("Xhamia Blu,Kisha e Shen Sofise,TopKapi")
                    .build();
            packagesRepository.save(p);
            stamboll = Optional.ofNullable(p);
        }

        Optional<Package> valbone  = packagesRepository.findByTitle("Valbone");
        if (valbone.isEmpty()) {
            Package p = Package.builder()
                    .departureTime("05/07/2022")
                    .returnTime("08/07/2022")
                    .title("Valbone")
                    .description("")
                    .price(75f)
                    .duration(2)
                    .imageSrc("")
                    .location("Liqeni i Komanit,Fierzës,Xhemës")
                    .build();
            packagesRepository.save(p);
            valbone = Optional.ofNullable(p);
        }
        Optional<Package> budva  = packagesRepository.findByTitle("Budva-Kotorr");
        if (budva.isEmpty()) {
            Package p = Package.builder()
                    .departureTime("06/07/2022")
                    .returnTime("09/07/2022")
                    .title("Budva-Kotorr")
                    .description("")
                    .price(109f)
                    .duration(3)
                    .imageSrc("")
                    .location(" Qyteti i Vjeter, Porti i Jahteve, Gjirii i Kotorit")
                    .build();
            packagesRepository.save(p);
            budva = Optional.ofNullable(p);
        }
        Optional<Package> sarand  = packagesRepository.findByTitle("SARANDË - KSAMIL");
        if (sarand.isEmpty()) {
            Package p = Package.builder()
                    .departureTime("07/07/2022")
                    .returnTime("10/07/2022")
                    .title("SARANDË - KSAMIL")
                    .description("")
                    .price(130f)
                    .duration(3)
                    .imageSrc("")
                    .location(" Krorez,Kakome,Gremina,Plazhi Ushtarit,Gjiri Rrojdhes")
                    .build();
            packagesRepository.save(p);
            sarand = Optional.ofNullable(p);
        }
        Optional<Package> karaburun  = packagesRepository.findByTitle("KARABURUN – SAZAN");
        if (karaburun.isEmpty()) {
            Package p = Package.builder()
                    .departureTime("12/07/2022")
                    .returnTime("12/07/2022")
                    .title("KARABURUN – SAZAN")
                    .description("")
                    .price(25f)
                    .duration(1)
                    .imageSrc("")
                    .location(" Ishulli i Sazanit,Shpella Haxhi Alise")
                    .build();
            packagesRepository.save(p);
            karaburun = Optional.ofNullable(p);
        }
        Optional<Package> puglia  = packagesRepository.findByTitle("PUGLIA");
        if (puglia.isEmpty()) {
            Package p = Package.builder()
                    .departureTime("16/07/2022")
                    .returnTime("19/07/2022")
                    .title("PUGLIA")
                    .description("")
                    .price(300f)
                    .duration(3)
                    .imageSrc("")
                    .location(" PUGLIA,ITALY")
                    .build();
            packagesRepository.save(p);
            puglia = Optional.ofNullable(p);
        }
        Optional<Package> zante = packagesRepository.findByTitle("Zankithos");
        if (zante.isEmpty()) {
            Package p = Package.builder()
                    .departureTime("06/07/2022")
                    .returnTime("12/07/2022")
                    .title("Zankithos")
                    .description("")
                    .price(210f)
                    .duration(7)
                    .imageSrc("")
                    .location(" Zankithos,Grecce")
                    .build();
            packagesRepository.save(p);
            zante = Optional.ofNullable(p);
        }
        Optional<Package> firence = packagesRepository.findByTitle("Firence");
        if (firence.isEmpty()) {
            Package p = Package.builder()
                    .departureTime("06/07/2022")
                    .returnTime("10/07/2022")
                    .title("Firence")
                    .description("")
                    .price(180f)
                    .duration(5)
                    .imageSrc("")
                    .location(" Firence,Italy")
                    .build();
            packagesRepository.save(p);
            firence = Optional.ofNullable(p);
        }
        Optional<Package> dhermi = packagesRepository.findByTitle("DHERMI");
        if (dhermi.isEmpty()) {
            Package p = Package.builder()
                    .departureTime("06/07/2022")
                    .returnTime("10/07/2022")
                    .title("DHERMI")
                    .description("")
                    .price(200f)
                    .duration(5)
                    .imageSrc("")
                    .location(" DHERMI")
                    .build();
            packagesRepository.save(p);
            dhermi = Optional.ofNullable(p);
        }


    }
}
