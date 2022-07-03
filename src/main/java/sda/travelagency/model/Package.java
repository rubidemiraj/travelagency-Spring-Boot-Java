package sda.travelagency.model;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import sda.travelagency.enums.PackageType;

import javax.persistence.*;
import java.util.UUID;

@Data
@Builder
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ta_package")
public class Package {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    @Column(name = "departure_time")
    private String departureTime;

    @Column(name = "return_time")
    private String returnTime;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Float price;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "image_src", columnDefinition = "TEXT")
    private String imageSrc;

    @Column(name = "location")
    private String location;

    @Column(name = "package_type")
    @Enumerated(EnumType.STRING)
    protected PackageType packageType;

    @Column(name = "country_id")
    private String countryId;

    @ManyToOne
    @JoinColumn(name = "country_id", updatable = false, insertable = false)
    private Country country;
}