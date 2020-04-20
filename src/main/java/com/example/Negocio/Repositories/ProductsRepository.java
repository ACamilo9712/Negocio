package com.example.Negocio.Repositories;

import com.example.Negocio.Producto.Domain.Product;
import com.example.Negocio.Producto.Domain.ProductId;
import com.example.Negocio.Producto.Domain.ProductOperationRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository {

    ProductOperationRequest insertOne(ProductOperationRequest operationRequest);

   ProductOperationRequest findById(Long id);

    List<Product> findAll();

    ProductOperationRequest updateOne(Long id, ProductOperationRequest operationRequest);

    boolean deleteOne(Long id);

}
