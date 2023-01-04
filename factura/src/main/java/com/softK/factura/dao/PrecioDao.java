package com.softK.factura.dao;

import com.softK.factura.dto.PrecioDTO;
import com.softK.factura.exception.DaoExceptions;
import com.softK.factura.mapper.PrecioMapper;
import com.softK.factura.mapper.VendedorMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PrecioDao implements PrecioDaoInterfaz{
    JdbcTemplate jdbcTemplate;

    public PrecioDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(PrecioDTO precioDTO) throws DaoExceptions {

        String insert = "INSERT INTO precio\n" +
                "(precio, fedesde, fehasta, sku)\n" +
                "VALUES(?, ?, ?, ?)";
        try{
            jdbcTemplate.update(insert, precioDTO.getPrecio(), precioDTO.getFedesde(), precioDTO.getFehasta(), precioDTO.getProductoDTO().getSku());
        }catch (Exception e){
            throw new DaoExceptions(e);
        }
    }

    @Override
    public void update(PrecioDTO precioDTO) throws DaoExceptions {
        String update = "UPDATE precio\n" +
                "SET precio=?, fedesde=?, fehasta=?, sku=?\n" +
                "WHERE nmprecio=?\n";

        try{
            jdbcTemplate.update(update, precioDTO.getPrecio(), precioDTO.getFedesde(), precioDTO.getFehasta(), precioDTO.getProductoDTO().getSku());
        }catch (Exception e){
            throw new DaoExceptions(e);
        }
    }

    @Override
    public void delete(PrecioDTO precioDTO) throws DaoExceptions {
        String delete = "DELETE FROM precio\n" +
                "WHERE nmprecio=?;\n";

        try{
            jdbcTemplate.update(delete, precioDTO.getNmprecio());
        }catch (Exception e)
        {
            throw new DaoExceptions(e);
        }
    }

    @Override
    public List getPrecios() throws DaoExceptions {
        String getall = "SELECT pr.nmprecio, pr.precio, pr.fedesde, pr.fehasta, pr.sku, p.dsproducto\n" +
                "FROM precio pr\n" +
                "inner join producto p on pr.sku = p.sku " +
                "order by pr.nmprecio";

        try{
            return jdbcTemplate.query(getall, new PrecioMapper());
        }catch (Exception e){
            throw new DaoExceptions(e);
        }
    }

    @Override
    public PrecioDTO getPreciosById(PrecioDTO precioDTO) throws DaoExceptions {
        String getbyid = "SELECT pr.nmprecio, pr.precio, pr.fedesde, pr.fehasta, pr.sku, p.dsproducto\n" +
                "FROM precio pr " +
                "inner join producto p on pr.sku = p.sku" +
                " where nmprecio = ?\n";

        try{
            return jdbcTemplate.queryForObject(getbyid, new PrecioMapper(), precioDTO.getNmprecio());
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }
}
