package com.controle.de.estoque.service;

import com.controle.de.estoque.model.Produto;

import java.util.Optional;

public interface ProdutoService {
    public Iterable<Produto> buscarTodosProdutos();

    public void cadastraProduto(Produto produto);


    public Optional<Produto> consultarEstoqueId(Long id);

    public void salvarProduto(Produto produto);


    public Optional<Produto> atualizarEstoque(Long id, int quantidadeAtualizada);

    public Optional<Produto> removerDoEtoque(Long id, int removerEstoque);

    public Optional<Produto> ativarProduto(Long id, boolean ativar);


    public abstract void excluirProduto (Long id);

    public void excluirProdutoComCascade(Long id);

    public void excluirProdutoComRemocaoManual(Long id);
}
