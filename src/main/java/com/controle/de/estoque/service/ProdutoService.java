package com.controle.de.estoque.service;

import com.controle.de.estoque.model.Produto;

import java.util.Optional;

public interface ProdutoService {
    public Iterable<Produto> buscarTodosProdutos();
    public void cadastraProduto(Produto produto);

    public Optional<Produto> consultarEstoqueId(Long id);

    public void salvarProduto (Produto produto);
}
