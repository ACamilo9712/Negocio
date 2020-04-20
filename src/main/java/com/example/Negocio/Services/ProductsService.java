package com.example.Negocio.Services;

import com.example.Negocio.Producto.Domain.*;
import com.example.Negocio.Repositories.SqlProductsRepository;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    private final Gson gson;
    private final SqlProductsRepository sqlProductsRepository;

    public ProductsService(Gson gson, SqlProductsRepository sqlProductsRepository) {
        this.gson = gson;
        this.sqlProductsRepository = sqlProductsRepository;
    }

    public ProductOperationRequest insertOne(Name name,Description description,BasePrice basePrice,TaxRate taxRate, ProductStatus status, InventoryQuantity quantity){
        ProductOperationRequest resp =  sqlProductsRepository.insertOne(ProductOperationRequest.of(name,description,basePrice,taxRate,status,quantity));
     return  resp;

    }

    public ProductOperationRequest findById(Long id){
        ProductOperationRequest request =  sqlProductsRepository.findById(id);
        return  request;
    }

    public List<Product> findAll(){
        List<Product> all=sqlProductsRepository.findAll();
        return all;
    }

    public  ProductOperationRequest updateOne(Long id, Name name,Description description,BasePrice basePrice,TaxRate taxRate, ProductStatus status, InventoryQuantity quantity){
        ProductOperationRequest request = sqlProductsRepository.updateOne(id, ProductOperationRequest.of(name,description,basePrice,taxRate,status,quantity));
        System.out.println(request);
        return  request;
    }


}
