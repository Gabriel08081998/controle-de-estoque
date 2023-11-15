package com.controle.de.estoque.service.impl;

import com.controle.de.estoque.model.Produto;
import com.controle.de.estoque.model.Venda;
import com.controle.de.estoque.repository.ProdutoRepository;
import com.controle.de.estoque.repository.VendaRepository;
import com.controle.de.estoque.service.VendaService;
import com.controle.de.estoque.view.VendaDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaServiceImpl implements VendaService {

    @Autowired
    private VendaRepository vendaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    public void realizarVenda(VendaDTO vendaDTO) {
        //Verificar se o produto existe
        Produto produto = produtoRepository.findById(vendaDTO.getId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        // Verificar se há estoque suficiente para a venda
        //se quantidade for maior quantidadeEstoque
        if (vendaDTO.getQuantidade() > produto.getQuantidadeEstoque()) {
            throw new RuntimeException("Quantidade insuficiente em estoque");
        }
        //inserir a venda
        Venda venda = new Venda();
        BeanUtils.copyProperties(vendaDTO, venda);
        venda.setProduto(produto);

        double valorTotal =  venda.getQuantidade() * produto.getValor();
        venda.setValorTotal(valorTotal);

        vendaRepository.save(venda);

        //atualizar estoque do produto
        int novoEstoque = produto.getQuantidadeEstoque() - venda.getQuantidade() ;
        produto.setQuantidadeEstoque(novoEstoque);

        produtoRepository.save(produto);
    }

    @Override
    public List<Venda> atualizacaoEstoque(long id, int quantidade) {
        return null;
    }

    private void SalvarPedido(Venda venda){
        vendaRepository.save(venda);
    }

}
