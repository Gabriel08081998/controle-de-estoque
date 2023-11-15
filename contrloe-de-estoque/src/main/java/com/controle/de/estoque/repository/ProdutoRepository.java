package com.controle.de.estoque.repository;

import com.controle.de.estoque.model.Produto;
import org.springframework.data.repository.CrudRepository;


public interface ProdutoRepository extends CrudRepository<Produto,Long> {

}