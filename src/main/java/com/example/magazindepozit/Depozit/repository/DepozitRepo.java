package com.example.magazindepozit.Depozit.repository;

import com.example.magazindepozit.Depozit.model.Depozit;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface DepozitRepo extends JpaRepository<Depozit, Long> {
    @Query("SELECT d from Depozit d where d.nume= ?1")
    @EntityGraph(attributePaths = {"magazine"}, type = EntityGraph.EntityGraphType.LOAD)
    Optional<Depozit> findDepozitByNume(String nume);

    @Query("SELECT d from Depozit d where d.id= ?1")

    @EntityGraph(attributePaths = {"magazine"}, type = EntityGraph.EntityGraphType.LOAD)
    Optional<Depozit> findById(Long id);

}
