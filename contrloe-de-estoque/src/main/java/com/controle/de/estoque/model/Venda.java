package com.controle.de.estoque.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Pode variar dependendo do seu banco de dados
    private long id;
    private int quantidade;
    private double valorTotal;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

}
