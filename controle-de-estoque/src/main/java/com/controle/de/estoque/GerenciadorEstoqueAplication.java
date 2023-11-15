package com.controle.de.estoque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GerenciadorEstoqueAplication {
    public static void main(String[] args) {
        SpringApplication.run(GerenciadorEstoqueAplication.class, args);
    }
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