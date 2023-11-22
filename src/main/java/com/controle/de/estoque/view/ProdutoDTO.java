package com.controle.de.estoque.view;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProdutoDTO {

        @NotNull
        private String nomeProduto;
        @NotNull
        private String modelo;
        private double valor;
        @NotNull
        private int quantidadeEstoque;
        private String anoFabricacao;

}
