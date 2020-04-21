package com.example.Negocio.Repositories;

import com.example.Negocio.Producto.Domain.Product;
import com.example.Negocio.Producto.Domain.ProductId;
import com.example.Negocio.Producto.Domain.ProductOperation;
import com.example.Negocio.Producto.Domain.ProductOperationRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductsRepository {

    ProductOperation insertOne(ProductOperationRequest operationRequest);

    ProductOperation findById(Long id);

    List<Product> findAll();

    ProductOperation updateOne(Long id, ProductOperationRequest operationRequest);

    ProductOperation deleteOne(Long id);

}
