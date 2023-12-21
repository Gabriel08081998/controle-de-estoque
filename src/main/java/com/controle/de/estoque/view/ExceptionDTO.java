package com.controle.de.estoque.view;

public class ExceptionDTO {

    public static class VendasAssociadasException extends RuntimeException {
        public VendasAssociadasException(String message) {
            super(message);
        }
    }

    public static class ProdutoNaoEncontradoException extends RuntimeException {
        public ProdutoNaoEncontradoException(Long id) {
            super("Produto não encontrado com o ID: " + id);
        }
    }
}
