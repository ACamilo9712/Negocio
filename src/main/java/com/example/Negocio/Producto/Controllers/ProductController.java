package com.example.Negocio.Producto.Controllers;


import com.example.Negocio.Producto.Domain.Product;
import com.example.Negocio.Producto.Domain.ProductId;
import com.example.Negocio.Producto.Domain.ProductOperationRequest;
import com.example.Negocio.Producto.Domain.ProductStatus;
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
    public ProductOperationRequest insertOne(@RequestBody ProductOperationRequest operationRequest){
        return service.insertOne(operationRequest.getName(), operationRequest.getDescription(), operationRequest.getBasePrice(), operationRequest.getTaxRate(),
                operationRequest.getProductStatus(), operationRequest.getInventoryQuantity());
    }

    @GetMapping("/{id}")
    public  ProductOperationRequest findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping("list")
    public List<Product> findAll(){
        return service.findAll();
    }

    @PutMapping("/{id}")
    public ProductOperationRequest updateOne(@PathVariable Long id,@RequestBody ProductOperationRequest operationRequest){
        System.out.println(">>>>>"+id);
        return service.updateOne(id, operationRequest.getName(), operationRequest.getDescription(), operationRequest.getBasePrice(), operationRequest.getTaxRate(),
                operationRequest.getProductStatus(), operationRequest.getInventoryQuantity());
    }
    @DeleteMapping("/{id}")
    public boolean deleteOne(@PathVariable Long id){
        return service.deleteOne(id);
    }
}
