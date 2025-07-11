package com.example.filmes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Filme {
    @Id // Indica que esse campo é uma chave primaria da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define que o valor do ID será gerado automaticamente pelo banco de dados
    private Long id;

    private String titulo;
    private String genero;
    private int ano;
    private int classificacao;


}
