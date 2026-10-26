package com.pgualberto.produtosapi.repository;

import com.pgualberto.produtosapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Product, String> {


    String id(String id);

    List<Product> findByName(String name);
}
