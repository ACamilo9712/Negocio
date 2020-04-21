package com.example.Negocio.Producto.Controllers;


import com.example.Negocio.Producto.Domain.*;
import com.example.Negocio.Services.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ProductOperationRequest updateOne(@PathVariable Long id, @RequestBody ProductOperationRequest operationRequest) {
         service.updateOne(id, operationRequest.getName(), operationRequest.getDescription(), operationRequest.getBasePrice(), operationRequest.getTaxRate(),
                operationRequest.getProductStatus(), operationRequest.getInventoryQuantity());
        return operationRequest;
    }

    @DeleteMapping("/{id}")
    public ProductOperation deleteOne(@PathVariable Long id) {
        return service.deleteOne(id);
    }
}
