package com.controle.de.estoque.model;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomeProduto;
    private String modelo;
    private int quantidadeEstoque;
    private double valor;
    private String anoFabricacao;


}
