package com.example.Negocio.Serialization;

import com.example.Negocio.Domain.Producto.Name;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringValueAdapterTest {
    static Gson gson;
    @BeforeAll
    static void setUp() {
        gson = new GsonBuilder()
                .registerTypeAdapter(Name.class, new StringValueAdapter<>(Name::of))
                .create();
    }


    @Test
    void deserialize() {
    }

    @Test
    void serialize() {
        // organizar
        String usernameString = "ElPutas";
        Name name = Name.of(usernameString);

        //actuar
        String actual = gson.toJson(name);

        //comprueban
        String expected = String.format("\"%s\"", name.getValue());
        assertEquals(actual, expected);
    }

}