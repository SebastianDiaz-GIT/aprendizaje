package com.softK.factura.dao;
import com.softK.factura.dto.ClienteDTO;
import com.softK.factura.dto.ProductoDTO;
import com.softK.factura.exception.DaoExceptions;
import com.softK.factura.mapper.ClienteMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ClienteDAO implements ClienteDaoInterfaz{

    private JdbcTemplate jdbcTemplate;

    public ClienteDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(ClienteDTO clienteDTO) throws DaoExceptions
    {
        String insertar = "INSERT INTO mia.cliente\n" +
                "(documento, dsnombre, dsapellido, dsdireccion)\n" +
                "VALUES(?, ?, ?, ?);\n";
        try{
            jdbcTemplate.update(insertar, clienteDTO.getDocumento(), clienteDTO.getDsNombres(), clienteDTO.getDsApellidos(), clienteDTO.getDsDireccion());
        }
        catch (Exception ex)
        {
            throw new DaoExceptions(ex);
        }


    }

    public void delete(ClienteDTO clienteDTO) throws DaoExceptions
    {
        String borrar = "DELETE FROM cliente\n" +
                "WHERE nmcliente=?;\n";

        try{
            jdbcTemplate.update(borrar, clienteDTO.getNmCliente());
        }catch (Exception e){
            throw new DaoExceptions(e);
        }
    }

    public void update(ClienteDTO clienteDTO) throws DaoExceptions{
        String update = "UPDATE mia.cliente\n" +
                "SET dsnombre=?, dsapellido=?, dsdireccion=?\n" +
                "WHERE documento=?";

        try{
            jdbcTemplate.update(update, clienteDTO.getDsNombres(), clienteDTO.getDsApellidos(), clienteDTO.getDsDireccion(), clienteDTO.getDocumento());
        }catch (Exception ex)
        {
            throw new DaoExceptions(ex);
        }
    }

    public List getAll() throws DaoExceptions
    {
        String get_clientes_query = "SELECT nmcliente, documento, dsnombre, dsapellido, dsdireccion\n" +
                "FROM cliente;\n";

        try{
            return jdbcTemplate.query(get_clientes_query, new ClienteMapper());
        }catch (Exception e){
            throw new DaoExceptions(e);
        }
    }

    public ClienteDTO getById(ClienteDTO clienteDTO) throws DaoExceptions
    {
        String getByDoc = "select nmcliente, documento, dsnombre, dsapellido, dsdireccion" +
                " from cliente where documento=?";

        try{
            return jdbcTemplate.queryForObject(getByDoc, new ClienteMapper(), clienteDTO.getDocumento());
        }catch (EmptyResultDataAccessException e)
        {
            return null;
        }
    }
}
