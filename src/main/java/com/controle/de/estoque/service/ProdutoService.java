package com.controle.de.estoque.service;

import com.controle.de.estoque.model.Produto;

import java.util.Optional;

public interface ProdutoService {
    public Iterable<Produto>buscarTodosCalcados();
    public void cadastraCalcado(Produto produto);

    public Optional<Produto> consultarEstoqueId(Long id);
}
