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
    private String nomeCalcado;
    private String modelo;
    private int quantidadeEstoque;
    private double valor;
    private String anoFabricacao;


}
//    Preciso de uma API para controle de estoque de calçados. Essa API inicialmente precisa ter 3 endpoints.
//
//        O primeiro endpoint é utilizado para cadastrar um calçado novo.
//        Precisa cadastrar o nome do calçado, modelo, valor, ano de fabricação e quantidade que tem em estoque.
//
//        O segundo endpoint é para realizar a atualização de estoque.
//        Precisa atualizar a quantidade de itens que tem no estoque.
//
//        O terceiro é a realização da venda de um calçado.
//        Para realizar a venda, deve ter uma tabela para controlar as vendas.
//        Onde essa tabela terá o id do produto a quantidade e o valor.
//        Após a venda o estoque deve ser atualizado, diminuindo a quantidade de itens vendidos.