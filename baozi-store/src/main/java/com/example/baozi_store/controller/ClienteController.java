package com.example.baozi_store.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.baozi_store.model.Cliente;
import com.example.baozi_store.repository.ClienteRepository;

@RestController
public class ClienteController {

    @PostMapping("/clientes")
    public Cliente criarCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    
    @GetMapping("/clientes")
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }
    
    @GetMapping("/clientes/{id}")
    public Cliente buscarCliente(@PathVariable Long id) {
        return clienteRepository.findById(id).orElse(null);
    }
    
    
    @DeleteMapping("/clientes/{id}")
    public void excluirCliente(@PathVariable Long id) {
        clienteRepository.deleteById(id);
    }
    
    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
}