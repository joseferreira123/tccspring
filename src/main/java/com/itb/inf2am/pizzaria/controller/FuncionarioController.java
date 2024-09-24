package com.itb.inf2am.pizzaria.controller;


// @Controller      -> Exclusivo para sistemas web
// @RestController  -> Exclusivo para APIS


import com.itb.inf2am.pizzaria.model.Cliente;
import com.itb.inf2am.pizzaria.services.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cliente")     // @RequestMapping: Mapeamento da url principal
public class FuncionarioController {

    private final ClienteService clienteService;

    public FuncionarioController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/categoria")    // @GetMapping: Complemento da url principal, exclusivo para consultas
    public ResponseEntity<List<Cliente>> listarTodosClientes() {


        return ResponseEntity.ok().body(clienteService.listarTodosClientes());
    }

}
