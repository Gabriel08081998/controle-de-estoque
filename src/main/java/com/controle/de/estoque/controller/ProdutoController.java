package com.controle.de.estoque.controller;

import com.controle.de.estoque.model.Produto;
import com.controle.de.estoque.service.ProdutoService;
import com.controle.de.estoque.view.ExceptionDTO;
import com.controle.de.estoque.view.ProdutoDTO;
import com.controle.de.estoque.view.ProdutoResponseDTO;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("produto")
@Api(tags = "Produtos", description = "API para operações relacionadas a produtos") // Adicione em seus controladores
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<Iterable<Produto>> buscarTodosProdutos() {
        return ResponseEntity.ok(produtoService.buscarTodosProdutos());
    }

    @PostMapping
    public ResponseEntity<?> cadastraProdutos(@Valid @RequestBody ProdutoDTO produtoDTO) {
        try {
            Produto produto1 = new Produto();
            BeanUtils.copyProperties(produtoDTO, produto1);
            produtoService.cadastraProduto(produto1);
            return ResponseEntity.ok(produto1);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Já existe um produto com esses dados.");
        }

    }

    @PutMapping("/atualizarEstoque/{id}")
    public ResponseEntity<?> atualizarEstoque(@PathVariable Long id, @RequestBody Map<String, Integer> requestBody) {
        Integer quantidadeAtualizada = requestBody.get("quantidadeAtualizada");
        try {
            Optional<Produto> produtoAtualizado = produtoService.atualizarEstoque(id, quantidadeAtualizada);

            if (produtoAtualizado.isPresent()) {
                return ResponseEntity.ok(produtoAtualizado.get());
            } else {
                return ResponseEntity.ok("Produto não encontrado");
            }

        } catch (Exception e) {
            ProdutoResponseDTO produtoResponseDTO = new ProdutoResponseDTO();
            produtoResponseDTO.setMessage(e.getMessage());
            produtoResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.of(Optional.of(produtoResponseDTO));

        }

    }

    @PutMapping("ativarProduto/{id}/{ativar}")
    public ResponseEntity<?> ativarProduto(@PathVariable Long id, @PathVariable boolean ativar) {
        try {
            // Chama o serviço para ativar ou desativar o produto com o ID fornecido
            Optional<Produto> produto = produtoService.ativarProduto(id, ativar);

            // Verifica se o produto foi encontrado e atualizado com sucesso
            if (produto.isPresent()) {
                return ResponseEntity.ok(produto.get());
            } else {
                // Retorna uma mensagem se o produto não for encontrado
                return ResponseEntity.ok("Produto nao encontrado");
            }
        } catch (Exception e) {
            // Em caso de exceção, cria um objeto de resposta com uma mensagem de erro
            ProdutoResponseDTO produtoResponseDTO = new ProdutoResponseDTO();
            produtoResponseDTO.setMessage(e.getMessage());
            produtoResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.of(Optional.of(produtoResponseDTO));
        }
    }


    @PutMapping("removerEstoque/{id}")
    public ResponseEntity<?> removerDoEtoque(@PathVariable Long id, @RequestBody Map<String, Integer> requestBody) {
        Integer removerEstoque = requestBody.get("removerEstoque");
        try {

            Optional<Produto> removerProduto = produtoService.removerDoEtoque(id, removerEstoque);

            if (removerProduto.isPresent()) {
                return ResponseEntity.ok(removerProduto.get());
            } else {
                ProdutoResponseDTO produtoResponseDTO = new ProdutoResponseDTO();
                produtoResponseDTO.setMessage("Produto nao encontrado!!");
                produtoResponseDTO.setStatus(HttpStatus.NO_CONTENT.value());
                return ResponseEntity.of(Optional.of(produtoResponseDTO));
            }

        } catch (Exception e) {
            ProdutoResponseDTO produtoResponseDTO = new ProdutoResponseDTO();
            produtoResponseDTO.setMessage(e.getMessage());
            produtoResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.of(Optional.of(produtoResponseDTO));

        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> excluirProduto(
            @PathVariable Long id, @RequestParam(defaultValue = "CASCADE") String exclusao) {
        try {
            if ("CASCADE".equalsIgnoreCase(exclusao)){
                produtoService.excluirProdutoComCascade(id);
            }else if ("MANUAL".equalsIgnoreCase(exclusao)){
                produtoService.excluirProdutoComRemocaoManual(id);
            }else {
                Map<String, String> resposta = new HashMap<>();
                resposta.put("erro", "Método de exclusao não reconhecio");
                return ResponseEntity.badRequest().body(resposta);
            }
            Map<String ,String> resposta =new HashMap<>();
            resposta.put("mensagem", "Produto excluido com sucesso");
            return ResponseEntity.ok(resposta);
        }catch (ExceptionDTO.ProdutoNaoEncontradoException e){
            Map<String, String> resposta = new HashMap<>();
            resposta.put("erro", "Produto não encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resposta);
        }catch (ExceptionDTO.VendasAssociadasException e){
            Map<String, String> resposta = new HashMap<>();
            resposta.put("erro", "Não é possível excluir o produto pois há vendas associadas");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resposta);
        }catch (Exception e){
            Map<String, String> resposta = new HashMap<>();
            resposta.put("erro", "Erro ao excluir o produto");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resposta);

        }


    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consultarProdutosId(@PathVariable long id) {
        //fazer um tratamento se nao existir
        Optional<Produto> produto = produtoService.consultarEstoqueId(id);
        if (produto.isPresent()) {
            return ResponseEntity.ok(produto.get());
        } else {
            return ResponseEntity.ok("Produto nao encontrado");
        }
    }
}
