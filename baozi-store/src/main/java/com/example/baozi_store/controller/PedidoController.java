package com.example.baozi_store.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.baozi_store.model.Pedido;
import com.example.baozi_store.repository.PedidoRepository;

@RestController
public class PedidoController {
	
	private final PedidoRepository pedidoRepository;
	
	//construindo o delete
	
	@DeleteMapping("/pedidos/{id}")
	public void excluirPedido(@PathVariable Long id) {
		pedidoRepository.deleteById(id);
	} 
	
	//função para Post, salvar pedido no banco de dados
	
	@PostMapping("/pedidos")
	public Pedido criarPedido(@RequestBody Pedido pedido ) {
		return pedidoRepository.save(pedido);
	}
	
	//função para encontrar o pedido
	
	@GetMapping("/pedidos/{id}")
	public Pedido buscarPedido(@PathVariable Long id) {
		return pedidoRepository.findById(id).orElse(null);
	}
	
	//função para listar todos os pedidos
	
	@GetMapping("/pedidos")
	public List<Pedido> listarPedidos(){
		return pedidoRepository.findAll();
	}
	
	public PedidoController(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;}
}
