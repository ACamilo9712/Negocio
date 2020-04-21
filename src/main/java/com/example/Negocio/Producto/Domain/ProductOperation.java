package com.example.Negocio.Producto.Domain;

import com.example.Negocio.exceptions.ProductException;

public interface ProductOperation {

    ProductOperationRequest value();

    ProductException failure();

    Boolean isValid();
}
