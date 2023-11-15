package com.controle.de.estoque.service;

import com.controle.de.estoque.model.Produto;
import com.controle.de.estoque.model.Venda;
import com.controle.de.estoque.view.VendaDTO;

import java.util.List;


public interface VendaService {

    public List<Venda> atualizacaoEstoque (long id, int quantidade);
}
