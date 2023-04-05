package com.example.apijavacloud.model.repository;

import com.example.apijavacloud.model.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produtos, Integer> {
}
