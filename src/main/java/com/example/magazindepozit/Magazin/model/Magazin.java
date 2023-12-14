package com.example.magazindepozit.Magazin.model;

import com.example.magazindepozit.Depozit.model.Depozit;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Magazin")
@Table(name = "magazin")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Magazin {

    @Id
    @SequenceGenerator(name = "magazin_sequence", sequenceName = "magazin_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "magazin_sequence")
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "Name is necessary")
    private String name;

    @Column(name = "numaMall")
    @NotBlank(message = "Adresa este necesara")
    private String numaMall;

    @JsonBackReference
    @ManyToMany(mappedBy = "magazine", fetch = FetchType.LAZY)

    private List<Depozit> depozite=new ArrayList<>();

    @Override
    public String toString() {
        return "Magazin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numaMall='" + numaMall + '\'' +
                ", depozite=" + depozite +
                '}';
    }
}
