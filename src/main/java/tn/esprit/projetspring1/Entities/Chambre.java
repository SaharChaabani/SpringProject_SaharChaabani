package tn.esprit.projetspring1.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Chambre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idChambre;
    private int numeroChambre;
    @Enumerated (EnumType.STRING)
    private TypeChambre typeC;

    @ManyToOne
    private Bloc bloc;
    @OneToMany
    private Set<Reservation> reservations;
}

