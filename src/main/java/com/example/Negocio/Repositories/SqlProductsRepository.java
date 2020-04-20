package com.example.Negocio.Repositories;

import com.example.Negocio.Producto.Domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import sun.security.krb5.internal.crypto.Des;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SqlProductsRepository implements ProductsRepository{

    private final JdbcTemplate jdbcTemplate;


    public SqlProductsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }


    @Override
    public ProductOperationRequest insertOne(ProductOperationRequest operationRequest) {
        String SQL ="INSERT INTO PRODUCTOS (NOMBRE,DESCRIPCION,PRECIOBASE,TASAIMPUESTOS,ESTADO,CANTINVE) VALUES (?,?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder(); // inicializada {}
        PreparedStatementCreator psc = connection -> {
            PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,operationRequest.getName().getValue());
            ps.setString(2,operationRequest.getDescription().getValue());
            ps.setBigDecimal(3,operationRequest.getBasePrice().getValue());
            ps.setBigDecimal(4, operationRequest.getTaxRate().getValue());
            ps.setString(5,operationRequest.getProductStatus().toString());
            ps.setInt(6,operationRequest.getInventoryQuantity().getValue());
            return ps;
        };
        jdbcTemplate.update(
                psc,
                keyHolder // --> {}, {1}
        );
        long key = keyHolder.getKey().longValue();
         return operationRequest;

    }

    @Override
    public ProductOperationRequest findById(Long id) {
        String SQL ="SELECT NOMBRE,DESCRIPCION,PRECIOBASE,TASAIMPUESTOS,ESTADO,CANTINVE FROM PRODUCTOS WHERE IDEN =?";
        Object[] objects ={id};
        RowMapper<ProductOperationRequest> rowMapper = (resultSet, i) -> {
            Name name =Name.of(resultSet.getString( "NOMBRE"));
            Description descripcion = Description.of(resultSet.getString( "DESCRIPCION"));
            BasePrice precioBase = BasePrice.of( resultSet.getBigDecimal( "PRECIOBASE"));
            TaxRate tasaImpuesto = TaxRate.of( resultSet.getBigDecimal("TASAIMPUESTOS"));
            ProductStatus estado = ProductStatus.valueOf( resultSet.getString("ESTADO"));
            InventoryQuantity cantidadInventario =InventoryQuantity.of(resultSet.getInt("CANTINVE"));
            return ProductOperationRequest.of(name,descripcion,precioBase,tasaImpuesto,estado,cantidadInventario);
        };

        ProductOperationRequest productOperationRequest = jdbcTemplate.queryForObject(SQL,objects,rowMapper);
        return productOperationRequest;
    }

    @Override
    public List<Product> findAll() {
        String SQL ="SELECT IDEN,NOMBRE,DESCRIPCION,PRECIOBASE,TASAIMPUESTOS,ESTADO,CANTINVE FROM PRODUCTOS";
        RowMapper<Product> rowMapper = (resultSet, i) -> {
            ProductId id = ProductId.of(resultSet.getLong("IDEN"));
            Name name =Name.of(resultSet.getString( "NOMBRE"));
            Description descripcion = Description.of(resultSet.getString( "DESCRIPCION"));
            BasePrice precioBase = BasePrice.of( resultSet.getBigDecimal( "PRECIOBASE"));
            TaxRate tasaImpuesto = TaxRate.of( resultSet.getBigDecimal("TASAIMPUESTOS"));
            ProductStatus estado = ProductStatus.valueOf( resultSet.getString("ESTADO"));
            InventoryQuantity cantidadInventario =InventoryQuantity.of(resultSet.getInt("CANTINVE"));
            return Product.of(id,name,descripcion,precioBase,tasaImpuesto,estado,cantidadInventario);
        };
        List<Product> productsList = jdbcTemplate.query(SQL,rowMapper);
        return productsList;
    }


    @Override
    public ProductOperationRequest updateOne(Long id, ProductOperationRequest operationRequest) {
        String SQL ="UPDATE PRODUCTOS SET NOMBRE = ?, DESCRIPCION= ?, PRECIOBASE = ?, TASAIMPUESTOS = ?,ESTADO= ?,CANTINVE= ?  WHERE IDEN = ?";
        KeyHolder keyHolder = new GeneratedKeyHolder(); // inicializada {}
        PreparedStatementCreator psc = connection -> {
            PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,operationRequest.getName().getValue());
            ps.setString(2,operationRequest.getDescription().getValue());
            ps.setBigDecimal(3,operationRequest.getBasePrice().getValue());
            ps.setBigDecimal(4, operationRequest.getTaxRate().getValue());
            ps.setString(5,operationRequest.getProductStatus().toString());
            ps.setInt(6,operationRequest.getInventoryQuantity().getValue());
            ps.setLong(7, id);
            return ps;
        };
        jdbcTemplate.update(
                psc,
                keyHolder // --> {}, {1}
        );
        long key = keyHolder.getKey().longValue();
        return operationRequest;
    }

    @Override
    public boolean deleteOne(Long id) {
        String SQL ="DELETE FROM PRODUCTOS WHERE IDEN = ?";
        KeyHolder keyHolder = new GeneratedKeyHolder(); // inicializada {}
        PreparedStatementCreator psc = connection -> {
            PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, id);
            return ps;
        };
        jdbcTemplate.update(
                psc,
                keyHolder // --> {}, {1}
        );

         return keyHolder.getKey() == null;

    }
}
