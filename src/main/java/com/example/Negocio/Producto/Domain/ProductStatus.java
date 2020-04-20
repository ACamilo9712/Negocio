package com.example.Negocio.Producto.Domain;

import lombok.Value;

public enum ProductStatus {
    BORRADOR,
    PUBLICADO;

    ProductStatus() {
    }

    public static String fromHour (ProductStatus status){
        switch (status){
            case BORRADOR:
                return "BORRADOR";
            case PUBLICADO:
                return "PUBLICADO";
            default:
                throw  new UnsupportedOperationException();
        }
    }


}
