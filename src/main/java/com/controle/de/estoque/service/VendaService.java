package com.controle.de.estoque.service;

import com.controle.de.estoque.model.Produto;
import com.controle.de.estoque.model.Venda;

import java.util.Optional;


public interface VendaService {

    public Produto atualizacaoEstoque (long id, int quantidade);
}
