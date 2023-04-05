package com.example.apijavacloud.model.repository;

import com.example.apijavacloud.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Clientes, Integer> {
}
