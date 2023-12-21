package com.controle.de.estoque.service.impl;


import com.controle.de.estoque.model.Produto;
import com.controle.de.estoque.model.Venda;
import com.controle.de.estoque.repository.ProdutoRepository;
import com.controle.de.estoque.repository.VendaRepository;
import com.controle.de.estoque.service.ProdutoService;
import com.controle.de.estoque.view.ExceptionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private VendaRepository vendaRepository;

    @Override
    public Iterable<Produto> buscarTodosProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> atualizarEstoque(Long id, int quantidadeAtualizada) {
        try {
            Optional<Produto> produtoA = produtoRepository.findById(id);

            if (produtoA.isPresent()) {
                Produto produto = produtoA.get();

                if (quantidadeAtualizada > 0) {
                    produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + quantidadeAtualizada);
                    produtoRepository.save(produto);
                    return Optional.of(produto);
                } else if (quantidadeAtualizada == 0) {
                    return Optional.empty();
                } else {
                    throw new RuntimeException("Não é permitido diminuir o estoque. Use um valor maior que zero para aumentar o estoque.");
                }
            } else {
                return Optional.empty();
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException("A quantidade fornecida não é um número válido.", e);
        }
    }

    public Optional<Produto> removerDoEtoque(Long id, int removerEstoque) {
        Optional<Produto> produtoR = produtoRepository.findById(id);

        if (produtoR.isPresent()) {
            Produto produto = produtoR.get();

            if (removerEstoque < 0) {
                throw new RuntimeException("Valor negativo nao e permitido. Informe outro valor!!");

            } else if (removerEstoque > 0) {
                produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - removerEstoque);
                produtoRepository.save(produto);
                return Optional.of(produto);

            } else {
                return Optional.empty();
            }
        } else {
            return Optional.empty();
        }
    }

    public Optional<Produto> ativarProduto(Long id, boolean ativar) {
        Optional<Produto> produtoOpt = produtoRepository.findById(id);
        if (produtoOpt.isPresent()) {
            Produto produto = produtoOpt.get();
            produto.setAtivo(ativar);

            produtoRepository.save(produto);

            return Optional.of(produto);
        } else {
            return Optional.empty();
        }

    }

    @Override
    public void excluirProduto(Long id) {
        produtoRepository.deleteById(id);
    }

    @Transactional
    public void excluirProdutoComCascade(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new ExceptionDTO.ProdutoNaoEncontradoException(id));

        produtoRepository.delete(produto);
    }

    @Transactional
    public void excluirProdutoComRemocaoManual(Long id) {
       Produto produto = produtoRepository.findById(id)
               .orElseThrow(()-> new ExceptionDTO.ProdutoNaoEncontradoException(id));

        for (Venda venda: produto.getVendas()){
            vendaRepository.deleteById(venda.getId());
        }
       produtoRepository.delete(produto);

    }

    @Override
    public void cadastraProduto(Produto produto) {
        salvarProduto(produto);

    }

    // Procura um produto pelo ID
    @Override
    public Optional<Produto> consultarEstoqueId(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto;
    }

    public void salvarProduto(Produto produto) {
        produtoRepository.save(produto);
    }

}