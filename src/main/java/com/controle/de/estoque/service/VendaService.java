package com.controle.de.estoque.service;

import com.controle.de.estoque.model.Produto;



public interface VendaService {

    public Produto atualizacaoEstoque (long id, int quantidade);
}
