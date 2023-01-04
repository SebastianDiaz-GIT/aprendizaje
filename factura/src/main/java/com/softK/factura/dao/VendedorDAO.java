package com.softK.factura.dao;


import com.softK.factura.dto.VendedorDTO;
import com.softK.factura.exception.DaoExceptions;
import com.softK.factura.mapper.VendedorMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class VendedorDAO implements VendedorDaoInterface{

    JdbcTemplate jdbcTemplate;

    public VendedorDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(VendedorDTO vendedorDTO) throws DaoExceptions {

        String insert = "INSERT INTO mia.vendedor\n" +
                "(documentov, dsvnombre, dsvapellido, dsvdireccion)\n" +
                "VALUES(?, ?, ?, ?);\n";
        try{
            jdbcTemplate.update(insert, vendedorDTO.getDocumentov(), vendedorDTO.getDsvnombre(), vendedorDTO.getDsvapellido(), vendedorDTO.getDsvdireccion());
        }catch (Exception ex)
        {
            throw new DaoExceptions(ex);
        }
    }

    @Override
    public void delete(VendedorDTO vendedorDTO) throws DaoExceptions {
        String delete_query = "DELETE FROM mia.vendedor\n" +
                "WHERE nmvendedor=?\n";
        try{
            jdbcTemplate.update(delete_query, vendedorDTO.getNmvendedor());
        }catch (Exception e){
            throw new DaoExceptions(e);
        }
    }

    @Override
    public void update(VendedorDTO vendedorDTO) throws DaoExceptions {
        String update_query = "UPDATE mia.vendedor\n" +
                "SET documentov=?, dsvnombre=?, dsvapellido=?, dsvdireccion=?\n" +
                "WHERE nmvendedor=?;\n";
        try{
            jdbcTemplate.update(update_query, vendedorDTO.getDocumentov(), vendedorDTO.getDocumentov(), vendedorDTO.getDsvnombre(), vendedorDTO.getDsvapellido(), vendedorDTO.getDsvdireccion(), vendedorDTO.getNmvendedor());
        }catch (Exception e){
            throw new DaoExceptions(e);
        }
    }

    @Override
    public List getAll() throws DaoExceptions {
        String get_vendedor_query = "SELECT nmvendedor, documentov, dsvnombre, dsvapellido, dsvdireccion\n" +
                "FROM vendedor order by nmvendedor;\n";
        try{
            return jdbcTemplate.query(get_vendedor_query, new VendedorMapper());
        }catch (Exception e){
            throw new DaoExceptions(e);
        }
    }

    @Override
    public VendedorDTO getById(VendedorDTO vendedorDTO) throws DaoExceptions {
        String getbyid_query = "SELECT nmvendedor, documentov, dsvnombre, dsvapellido, dsvdireccion\n" +
                "FROM vendedor where documentov=?\n";
        try{
            return jdbcTemplate.queryForObject(getbyid_query, new VendedorMapper(), vendedorDTO.getDocumentov());
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }
}
