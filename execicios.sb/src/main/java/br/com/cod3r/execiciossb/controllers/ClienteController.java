package br.com.cod3r.execiciossb.controllers;

import br.com.cod3r.execiciossb.model.entities.Cliente;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @GetMapping("/qualquer")
    public Cliente obterCliente (){
        return  new Cliente( 28, "Pedro", "123.456.789-00");
    }
    @GetMapping("/{id}")
    public  Cliente obterClientePorId1(@PathVariable int id){
        return new Cliente(id, "maria","987.654.321-00");
    }
    @GetMapping
    public  Cliente obterClientePorId2(@RequestParam(name = "id",defaultValue = "1") int id){
        return new Cliente(id, "Joao augusto","1111.222.333-44");
    }
}
