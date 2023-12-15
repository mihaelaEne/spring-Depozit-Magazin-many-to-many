package com.example.magazindepozit.Depozit.model;

import com.example.magazindepozit.Magazin.model.Magazin;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Depozit")
@Table(name = "depozit")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Depozit {

    @Id
    @SequenceGenerator(name = "depozit_sequence", sequenceName = "depozit_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "depozit_sequence")
    private Long id;

    @Column(name = "nume")
    @NotBlank(message = "Numele este necessar")
    private String nume;

    @Column(name = "adresa")
    @NotBlank(message = "Adresa este necessar")
    private String adresa;

    @JsonManagedReference
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "joinTbDepozitMagazin",
            joinColumns = @JoinColumn(name = "depozit_id"),
            inverseJoinColumns = @JoinColumn(name = "magazin_id")
    )

    private List<Magazin> magazine=new ArrayList<>();

    @Override
    public String toString() {
        return "Depozit{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", adresa='" + adresa + '\'' +
                ", magazine=" + magazine +
                '}';
    }
}
