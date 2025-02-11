package tn.esprit.projetspring1.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Personne  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String nom ;
    private String prenom ;
    private int age ;
    @Temporal(TemporalType.DATE)
    private Date dateofbirth ;
    @Enumerated (EnumType.STRING)
    private Gender gender ;



}
