package com.example.Negocio.Controllers;

import com.example.Negocio.Domain.Producto.*;
import com.example.Negocio.Services.ProductsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ProductsService service;
    private ProductOperation productOperation;
    private List<Product> array;

    @Test
    void insertOne() throws Exception {
        BigDecimal bigDecimalPrice = new BigDecimal("11.2659");
        BigDecimal bigDecimalTax = new BigDecimal("0.25");
        Name name = Name.of("Andres");
        Description description = Description.of("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed...");
        BasePrice price = BasePrice.of( bigDecimalPrice);
        TaxRate taxRate = TaxRate.of(bigDecimalTax);
        ProductStatus status = ProductStatus.valueOf("PUBLICADO");
        InventoryQuantity quantity = InventoryQuantity.of(88);

        when(service.insertOne(name,description,price,taxRate, status,quantity ))
                .thenReturn(productOperation);

        //act
        MockHttpServletRequestBuilder servletRequestBuilder = MockMvcRequestBuilders.get("/api/v1/times");
        this.mockMvc.perform(servletRequestBuilder)
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void findById() throws Exception {
        when(service.findById(anyLong()))
                .thenReturn(productOperation);
        //act
        MockHttpServletRequestBuilder servletRequestBuilder = MockMvcRequestBuilders.get("/api/v1/times");
        this.mockMvc.perform(servletRequestBuilder)
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void findAll() throws Exception {
        when(service.findAll())
                .thenReturn(array);
        //act
        MockHttpServletRequestBuilder servletRequestBuilder = MockMvcRequestBuilders.get("/api/v1/times");
        this.mockMvc.perform(servletRequestBuilder)
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void updateOne() {

    }

    @Test
    void deleteOne() {
    }
}