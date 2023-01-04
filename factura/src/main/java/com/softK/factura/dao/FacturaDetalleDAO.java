package com.softK.factura.dao;

import com.softK.factura.dto.DetalleFacturaDTO;
import com.softK.factura.exception.DaoExceptions;
import com.softK.factura.mapper.detfacturamapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FacturaDetalleDAO implements FacturaDetalleDaoInterface {
    private JdbcTemplate jdbcTemplate;

    public FacturaDetalleDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void crear(DetalleFacturaDTO detalleFacturaDTO) throws DaoExceptions {
        String insert = "INSERT INTO mia.detallefactura\n" +
                "(cantidad, precio, sku, nmfactura, nmprecio)\n" +
                "VALUES(?, ?, ?, ?, ?);\n";

        try {
            jdbcTemplate.update(insert, detalleFacturaDTO.getCantidad(),
                                        detalleFacturaDTO.getPrecio(),
                                        detalleFacturaDTO.getSku().getSku(),
                                        detalleFacturaDTO.getNmfactura().getNmfactura(),
                                        detalleFacturaDTO.getNmprecio().getNmprecio());
        }catch (Exception e){
            throw new DaoExceptions(e);
        }
    }

    @Override
    public void delete(DetalleFacturaDTO detalleFacturaDTO) throws DaoExceptions {
        String delete = "DELETE FROM mia.detallefactura\n" +
                "WHERE nmdetfactura=?;\n";

        try{
            jdbcTemplate.update(delete, detalleFacturaDTO.getNmdetfactura());
        }catch (Exception e){
            throw new DaoExceptions(e);
        }
    }

    @Override
    public void update(DetalleFacturaDTO detalleFacturaDTO) throws DaoExceptions {
        String update = "UPDATE detallefactura\n" +
                "SET cantidad=?, precio=?, sku=?, nmfactura=?, nmprecio=?\n" +
                "WHERE nmdetfactura=?;\n";
        try{
            jdbcTemplate.update(update, detalleFacturaDTO.getCantidad(),
                                        detalleFacturaDTO.getPrecio(),
                                        detalleFacturaDTO.getSku().getSku(),
                                        detalleFacturaDTO.getNmfactura().getNmfactura(),
                                        detalleFacturaDTO.getNmprecio().getNmprecio(),
                                        detalleFacturaDTO.getNmdetfactura());
        }catch (Exception e){
            throw new DaoExceptions(e);
        }
    }

    @Override
    public DetalleFacturaDTO getbyid(DetalleFacturaDTO detalleFacturaDTO) throws DaoExceptions {
        String getbyid = "select d.nmdetfactura, d.cantidad, d.precio, d.sku, d.nmfactura, d.nmprecio\n" +
                "from detallefactura d \n" +
                "inner join factura f on d.nmfactura = f.nmfactura \n" +
                "inner join producto p on d.sku = p.sku \n" +
                "inner join precio p2 on d.nmprecio = p2.nmprecio\n" +
                "where nmdetfactura = ?";
        try{
            return jdbcTemplate.queryForObject(getbyid, new detfacturamapper(), detalleFacturaDTO.getNmdetfactura());
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List getall() throws DaoExceptions {
        String get_all = "select d.nmdetfactura, d.cantidad, d.precio, d.sku, d.nmfactura, d.nmprecio\n" +
                "from detallefactura d \n" +
                "inner join factura f on d.nmfactura = f.nmfactura \n" +
                "inner join producto p on d.sku = p.sku \n" +
                "inner join precio p2 on d.nmprecio = p2.nmprecio\n" +
                "order by nmdetfactura ";

        try{
            return jdbcTemplate.query(get_all, new detfacturamapper());
        }catch (Exception e){
            throw new DaoExceptions(e);
        }
    }
}
