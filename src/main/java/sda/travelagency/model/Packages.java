package sda.travelagency.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Table
@Entity(name = "PACKAGES")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Packages {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PackageId")
    private Long packageid;

    @Column(name = "DepartureTime")
    private String departureTime;

    @Column(name = "ReturnTime")
    private String returnTime;

    @Column(name = "DescriptionPack")
    private String descriptionPack;

    @Column(name = "HotelName")
    private String hotelName;


    @Column(name = "IndividualTrip")
    private boolean individual;

    @Column(name = "GuideTrip")
    private boolean guideTrip;


}