package com.softK.factura.mapper;

import com.softK.factura.dto.PrecioDTO;
import com.softK.factura.dto.ProductoDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PrecioMapper implements RowMapper<PrecioDTO> {


    @Override
    public PrecioDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        PrecioDTO preciomapper = new PrecioDTO();
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setSku(rs.getInt("sku"));
        productoDTO.setDsProducto(rs.getString("dsproducto"));

        preciomapper.setNmprecio(rs.getInt("nmprecio"));
        preciomapper.setPrecio(rs.getDouble("precio"));
        preciomapper.setFedesde(rs.getDate("fedesde"));
        preciomapper.setFehasta(rs.getDate("fehasta"));
        preciomapper.setProductoDTO(productoDTO);
        return preciomapper;
    }
}
