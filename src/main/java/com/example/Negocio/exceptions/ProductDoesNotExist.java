package com.example.Negocio.exceptions;


import com.example.Negocio.Producto.Domain.ProductOperationRequest;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Value;

import org.springframework.beans.factory.annotation.Autowired;

@EqualsAndHashCode(callSuper = true)
@Value(staticConstructor = "of")

public class ProductDoesNotExist extends ProductException {

    Long  id;

    public ProductDoesNotExist(Long id) {
        super(String.format("El producto con id"+ id +" no existe"));
        this.id =id;

    }
}
