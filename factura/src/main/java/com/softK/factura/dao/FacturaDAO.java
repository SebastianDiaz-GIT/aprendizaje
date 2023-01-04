package com.softK.factura.dao;

import com.softK.factura.dto.FacturaDTO;
import com.softK.factura.exception.DaoExceptions;
import com.softK.factura.mapper.FacturaMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FacturaDAO implements FacturaDaoInterfaz{

    private JdbcTemplate jdbcTemplate;

    public FacturaDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(FacturaDTO facturaDTO) throws DaoExceptions {
        String insertar = "INSERT INTO factura\n" +
                "(cdfactura, fecha_factura, nmcliente, nmvendedor)\n" +
                "VALUES(?, ?, ?, ?);\n\n";
        try{
            jdbcTemplate.update(insertar, facturaDTO.getCdfactura(), facturaDTO.getFefactura(), facturaDTO.getNmcliente().getNmCliente(), facturaDTO.getNmvendedor().getNmvendedor());
        }
        catch (Exception ex)
        {
            throw new DaoExceptions(ex);
        }

    }

    @Override
    public void update(FacturaDTO facturaDTO) throws DaoExceptions {
        String update = "UPDATE factura\n" +
                "SET cdfactura=?, fecha_factura=?, nmcliente=?, nmvendedor=?\n" +
                "WHERE nmfactura=?;\n";
        try{
            jdbcTemplate.update(update, facturaDTO.getCdfactura(), facturaDTO.getFefactura(), facturaDTO.getNmcliente().getNmCliente(), facturaDTO.getNmvendedor().getNmvendedor(), facturaDTO.getNmfactura());
        }
        catch (Exception ex)
        {
            throw new DaoExceptions(ex);
        }
    }

    @Override
    public void delete(FacturaDTO facturaDTO) throws DaoExceptions {
        String delete = "DELETE FROM factura\n" +
                "WHERE nmfactura=?;\n";
        try{
            jdbcTemplate.update(delete, facturaDTO.getNmfactura());
        }catch (Exception e){
            throw new DaoExceptions(e);
        }
    }

    @Override
    public List<FacturaDTO> getall() throws DaoExceptions {

        String get_all_facturas = "select f.nmfactura, f.cdfactura, f.fecha_factura, f.nmcliente, f.nmvendedor, \n" +
                "c.documento, c.dsnombre, c.dsapellido, c.dsdireccion,\n" +
                "v.documentov, v.dsvnombre, v.dsvapellido, v.dsvdireccion \n" +
                "from factura f\n" +
                "inner join cliente c on c.nmcliente = f.nmcliente \n" +
                "inner join vendedor v ON v.nmvendedor = f.nmvendedor\n" +
                "order by nmfactura \n";
        try{
            return jdbcTemplate.query(get_all_facturas, new FacturaMapper());
        }catch (Exception e){
            throw new DaoExceptions(e);
        }
    }

    @Override
    public FacturaDTO getbyid(FacturaDTO facturaDTO) throws DaoExceptions {

        String getbyid = "select f.nmfactura, f.cdfactura, f.fecha_factura, f.nmcliente, f.nmvendedor, \n" +
                "c.documento, c.dsnombre, c.dsapellido, c.dsdireccion,\n" +
                "v.documentov, v.dsvnombre, v.dsvapellido, v.dsvdireccion \n" +
                "from factura f\n" +
                "inner join cliente c on c.nmcliente = f.nmcliente \n" +
                "inner join vendedor v ON v.nmvendedor = f.nmvendedor\n" +
                "where nmfactura = ?";
        try{
            return jdbcTemplate.queryForObject(getbyid, new FacturaMapper(), facturaDTO.getNmfactura());
        }catch (EmptyResultDataAccessException e){
           return  null;
        }
    }
}
