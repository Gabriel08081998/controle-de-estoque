package br.com.cod3r.execiciossb.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/metodos")
public class metodosHttpController {

    @GetMapping
    public String get(){
        return "requiciçao GET";
    }
    @PostMapping
    public String post(){
        return "requiciçao POST";
    }
    @PutMapping
    public String put(){
        return "requiciçao pUT";
    }
    @PatchMapping
    public String patch(){
        return "requiciçao PATCH";
    }
    @DeleteMapping
    public String delete(){
        return "requiciçao DELETE";
    }
}
