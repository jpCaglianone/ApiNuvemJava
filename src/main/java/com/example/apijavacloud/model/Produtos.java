package com.example.apijavacloud.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "produtos_p01")
public class Produtos {

    private String nome;
    private String marca;
    private float valor;
    private int quantidade;
    private String descricao;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
