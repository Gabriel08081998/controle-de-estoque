package com.controle.de.estoque.controller.exception;

import com.controle.de.estoque.model.Produto;
import com.controle.de.estoque.service.ProdutoService;
import com.controle.de.estoque.view.ProdutoDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping("produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<Iterable<Produto>> buscarTodosCalcados(){
        return ResponseEntity.ok(produtoService.buscarTodosCalcados());
    }
    @PostMapping
    public  ResponseEntity<?> cadastraCalcado(@Valid @RequestBody ProdutoDTO produtoDTO){
        Produto produto1 = new Produto();
        BeanUtils.copyProperties(produtoDTO, produto1);
        produtoService.cadastraCalcado(produto1);
        return ResponseEntity.ok(produto1);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consultarProdutosId(@PathVariable long id){
        //fazer um tratamento se nao existir
        Optional<Produto> produto = produtoService.consultarEstoqueId(id);
        if(produto.isPresent()){
            return ResponseEntity.ok(produto.get());
        }else{
            return ResponseEntity.ok("Produto nao encontrado");
        }
    }
}
