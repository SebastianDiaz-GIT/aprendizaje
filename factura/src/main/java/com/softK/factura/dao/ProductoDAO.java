package com.softK.factura.dao;

import com.softK.factura.database.Conexion;
import com.softK.factura.database.ConexionManager;
import com.softK.factura.dto.ProductoDTO;
import com.softK.factura.exception.DaoExceptions;
import com.softK.factura.mapper.ProductoMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductoDAO implements ProductDaoInterface{
    private JdbcTemplate jdbcTemplate;


    public ProductoDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }


    public void insert(ProductoDTO producto) throws DaoExceptions {

        String insertar = "INSERT INTO producto\n" +
                "(sku,\n" +
                "dsproducto)\n" +
                "VALUES\n" +
                "(?,?)";
        try{
            jdbcTemplate.update(insertar, producto.getSku(), producto.getDsProducto());
        }catch (Exception ex)
        {
            throw new DaoExceptions(ex);

        }
    }

    public void delete(ProductoDTO producto)  throws DaoExceptions
    {

        String borrar = "DELETE FROM producto\n" +
                "WHERE sku=?;\n";

        try{
            jdbcTemplate.update(borrar, producto.getSku());
        }catch (Exception ex)
        {
            throw new DaoExceptions(ex);
        }
    }

    public void update(ProductoDTO producto) throws DaoExceptions {
        String insertar = "UPDATE producto\n" +
                "SET dsproducto=?\n" +
                "WHERE sku=?;\n";
        try{
            jdbcTemplate.update(insertar, producto.getDsProducto(), producto.getSku());
        }catch (Exception ex)
        {
            throw new DaoExceptions(ex);
        }
    }

    public ProductoDTO getbyid (ProductoDTO producto) throws DaoExceptions
    {

        String SELECT = "select sku, dsproducto from producto where sku=?";
        try{
            return jdbcTemplate.queryForObject(SELECT, new ProductoMapper(),producto.getSku());
        }catch (EmptyResultDataAccessException ex)
        {
            return null;
        }
    }

    public List getAll() throws DaoExceptions{
        String SELECTALL = "SELECT sku, dsproducto FROM producto ORDER BY sku";
        try{
            return jdbcTemplate.query(SELECTALL, new ProductoMapper());
        }catch (Exception e)
        {
            throw new DaoExceptions();
        }
    }

    @Override
    public List getbyname(ProductoDTO producto) throws DaoExceptions {

        String SELECT = "select sku, dsproducto from producto where dsproducto like " + producto.getDsProducto();
        try{
            return jdbcTemplate.query(SELECT, new ProductoMapper());
        }catch (EmptyResultDataAccessException ex)
        {
            return null;
        }
    }
}
