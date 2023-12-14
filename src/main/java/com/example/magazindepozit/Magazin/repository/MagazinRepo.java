package com.example.magazindepozit.Magazin.repository;

import com.example.magazindepozit.Magazin.model.Magazin;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MagazinRepo extends JpaRepository<Magazin,Long> {


    @Query("SELECT m FROM Magazin m where m.id= ?1")
    @EntityGraph(attributePaths = {"depozite"}, type= EntityGraph.EntityGraphType.LOAD)
    Optional<Magazin> findById(Long id);

    @Query("SELECT m FROM Magazin m where m.numaMall= ?1")
    Optional<Magazin>findMagazinByNumaMallString ( String numaMall);

    @Query("SELECT m FROM Magazin m where m.name= ?1")
    Optional<Magazin>findMagazinByNume(String name);


    @Modifying
    @Query("SELECT m FROM Magazin m  where m.name= ?1 and m.numaMall= ?2")
    void updateSalon(String name, String numaMall);


}
