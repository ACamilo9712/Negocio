package com.example.Negocio.Producto.Domain;

import lombok.Value;

@Value(staticConstructor = "of")
public class ProductOperationRequest {
    Name name;
    Description description;
    BasePrice basePrice;
    TaxRate taxRate;
    ProductStatus productStatus;
    InventoryQuantity inventoryQuantity;

}
