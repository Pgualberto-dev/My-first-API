package com.pgualberto.produtosapi.controller;


import com.pgualberto.produtosapi.model.Product;
import com.pgualberto.produtosapi.repository.ProductoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController // Serve para eu garantir que essa classe vai receber requisições rest
@RequestMapping("produtos")
public class ProductController {
    // para salvar um produto nos mapeamos para @PostMapping

    private ProductoRepository productoRepository;

    public ProductController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
    @PostMapping
    public Product save(@RequestBody Product product) {
        System.out.println("Produto recebido " + product);
        var id = UUID.randomUUID().toString();
        product.setId(id);
        productoRepository.save(product);
        return product;
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") String id) {//buscar via mapping request
        Optional<Product> product = productoRepository.findById(id);
        return productoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") String id) {// deletar via mapping request
        productoRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") String id,
                       @RequestBody Product product){ // atualizar produtos
        product.setId(id);
        productoRepository.save(product);
    }

    @GetMapping
    public List<Product> findAll (@RequestParam ("nome") String name) {
       return productoRepository.findByName(name);
    }
}