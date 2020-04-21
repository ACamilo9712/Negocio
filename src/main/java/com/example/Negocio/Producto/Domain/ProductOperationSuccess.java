package com.example.Negocio.Producto.Domain;

import com.example.Negocio.exceptions.ProductException;
import lombok.Data;
import lombok.Value;

@Value(staticConstructor = "of")
public class ProductOperationSuccess implements ProductOperation {

    ProductOperationRequest product;

    @Override
    public ProductOperationRequest value() {
        return product;
    }

    @Override
    public ProductException failure() {
        return null;
    }

    @Override
    public Boolean isValid() {
        return true;
    }
}
