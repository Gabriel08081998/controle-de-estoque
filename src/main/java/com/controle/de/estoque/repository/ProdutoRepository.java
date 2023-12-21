package com.controle.de.estoque.repository;

import com.controle.de.estoque.model.Produto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface ProdutoRepository extends CrudRepository<Produto,Long> {

    @Modifying
    @Query("DELETE FROM Produto p WHERE p.id = :id AND NOT EXISTS (SELECT 1 FROM Venda v WHERE v.produto = p)")
    void excluirProdutoComCascade(@Param("id") Long id);

    @Modifying
    @Query("DELETE FROM Produto p WHERE p.id = :id AND NOT EXISTS (SELECT 1 FROM Venda v WHERE v.produto = p)")
    void excluirProdutoComRemocaoManual(@Param("id") Long id);


}