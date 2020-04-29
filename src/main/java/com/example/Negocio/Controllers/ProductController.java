package com.example.Negocio.Controllers;


import com.example.Negocio.Domain.Producto.Product;
import com.example.Negocio.Domain.Producto.ProductOperation;
import com.example.Negocio.Domain.Producto.ProductOperationRequest;
import com.example.Negocio.Services.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/times")
@RequiredArgsConstructor
public class ProductController {

    private final ProductsService service;


    @PostMapping
    public ProductOperationRequest insertOne(@RequestBody ProductOperationRequest operationRequest) {
        service.insertOne(operationRequest.getName(), operationRequest.getDescription(), operationRequest.getBasePrice(), operationRequest.getTaxRate(),
                operationRequest.getProductStatus(), operationRequest.getInventoryQuantity());
        return operationRequest;
    }

    @GetMapping("/{id}")
    public ProductOperation findById(@PathVariable Long id) {
        ProductOperation optionalUser = service.findById(id);
        return optionalUser;
    }

    @GetMapping("list")
    public List<Product> findAll() {
        return service.findAll();
    }

    @PutMapping("/{id}")
    public ProductOperation updateOne(@PathVariable Long id, @RequestBody ProductOperationRequest operationRequest) {
        service.updateOne(id, operationRequest.getName(), operationRequest.getDescription(), operationRequest.getBasePrice(), operationRequest.getTaxRate(),
                operationRequest.getProductStatus(), operationRequest.getInventoryQuantity());
        return service.updateOne(id, operationRequest.getName(), operationRequest.getDescription(), operationRequest.getBasePrice(), operationRequest.getTaxRate(),
                operationRequest.getProductStatus(), operationRequest.getInventoryQuantity());
    }

    @DeleteMapping("/{id}")
    public ProductOperation deleteOne(@PathVariable Long id) {
        return service.deleteOne(id);
    }
}
