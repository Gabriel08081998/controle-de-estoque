package com.controle.de.estoque.service.impl;


import com.controle.de.estoque.model.Produto;
import com.controle.de.estoque.repository.ProdutoRepository;
import com.controle.de.estoque.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public Iterable<Produto> buscarTodosCalcados() {
        return produtoRepository.findAll();
    }

    @Override
    public void cadastraCalcado(Produto produto) {
        salvarcalcado(produto);

    }

    // Procura um produto pelo ID
    @Override
    public Optional<Produto> consultarEstoqueId(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto;
    }
    private void salvarcalcado(Produto produto){
        produtoRepository.save(produto);
    }

}