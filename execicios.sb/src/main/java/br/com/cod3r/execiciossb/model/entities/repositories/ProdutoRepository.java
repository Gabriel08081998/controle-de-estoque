package br.com.cod3r.execiciossb.model.entities.repositories;

import br.com.cod3r.execiciossb.model.entities.Produto;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface  ProdutoRepository extends PagingAndSortingRepository<Produto, Integer>{

    public Iterable<Produto> findByNomeContaining(String parteNome);

}
