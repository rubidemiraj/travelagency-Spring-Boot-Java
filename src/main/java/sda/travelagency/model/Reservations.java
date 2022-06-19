package sda.travelagency.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Table
@Entity(name = "RESERVATIONS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Reservations {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ReservationId")
    private Long reservationId;

    @Column(name = "ClientName")
    private String clientName;

    @Column(name = "ClientLastName")
    private String clientLastName;

    @Column(name = "ClientNrTel")
    private int clientNrTel;

    @Column(name = "Email")
    private String email;

    @Column(name = "NoChildren")
    private int noChildren;

    @Column(name = "NoAdults")
    private int noAdults;
}









