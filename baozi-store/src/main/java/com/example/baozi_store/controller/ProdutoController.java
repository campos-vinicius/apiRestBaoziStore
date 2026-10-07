package com.example.baozi_store.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.baozi_store.model.Produto;
import com.example.baozi_store.repository.ProdutoRepository;


@RestController
public class ProdutoController {
	
	@DeleteMapping("/produtos/{id}")
	public void excluirProduto(@PathVariable Long id) {
	    produtoRepository.deleteById(id);
	}
	
	@GetMapping("/produtos/{id}")
	public Produto buscarProduto(@PathVariable Long id) {
	    return produtoRepository.findById(id).orElse(null);
	}
	
	@GetMapping("/produtos")
	public List<Produto> listarProdutos() {
	    return produtoRepository.findAll();
	}
	
	@PostMapping("/produtos")
	public Produto criarProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	private final ProdutoRepository produtoRepository;
	
	public ProdutoController(ProdutoRepository produtoRepository) {
	this.produtoRepository = produtoRepository;}
}	
