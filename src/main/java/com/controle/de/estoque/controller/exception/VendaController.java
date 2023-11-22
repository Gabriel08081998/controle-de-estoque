package com.controle.de.estoque.controller.exception;


import com.controle.de.estoque.service.impl.VendaServiceImpl;
import com.controle.de.estoque.view.VendaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaServiceImpl vendaServiceImpl;

    @PostMapping("/realizar")
    public ResponseEntity<String> realizarVenda(@Valid @RequestBody VendaDTO vendaDTO) {
        // Chame o serviço de venda para realizar a venda
        vendaServiceImpl.realizarVenda(vendaDTO);


        return ResponseEntity.ok("Venda realizada com sucesso.");
    }

    @PutMapping("/atualizarEstoque")
    public void atualizacaoEstoque(@Valid @RequestBody VendaDTO vendaDTO) {
        vendaServiceImpl.atualizacaoEstoque(vendaDTO.getId(), vendaDTO.getQuantidade());
    }

}
