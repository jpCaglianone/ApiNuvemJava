package com.example.apijavacloud.controller;


import com.example.apijavacloud.model.Clientes;
import com.example.apijavacloud.model.service.ClienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

   private final ClienteService clienteService;

    public ClientesController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Clientes> listarClientes(){
        return clienteService.listaClientes();
    }

    
    @GetMapping("/{id}")
    public Optional<Clientes> listarClientes(@PathVariable int id){
        try {
            return clienteService.listaClientePorId(id);
        }
        catch (Exception e){
            System.out.println("Usuario nao encontrado");
            return null;
        }
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Clientes incluiCliente(@RequestBody  Clientes cliente){
        return clienteService.incluiCliente(cliente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletaCliente(@PathVariable int id){
        clienteService.excluiCliente(id);
    }

    @PutMapping("/{id}")
    public Clientes atualizarCliente(@PathVariable int id, @RequestBody Clientes clienteAlterado){
        Clientes clienteAtual = clienteService.listaClientePorId(id).get();
        BeanUtils.copyProperties(clienteAlterado,clienteAtual,"id");

        return clienteService.incluiCliente(clienteAtual);
    }
}