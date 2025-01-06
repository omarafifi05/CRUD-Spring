package com.bmt.webapp.repositories;
import com.bmt.webapp.model.Clients;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Clients, Integer> {
    public Clients findByEmail(String email);

    Optional<Clients> findById(int id);


}
