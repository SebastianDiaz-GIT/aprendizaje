package com.softK.factura.mapper;

import com.softK.factura.dto.DetalleFacturaDTO;
import com.softK.factura.dto.FacturaDTO;
import com.softK.factura.dto.PrecioDTO;
import com.softK.factura.dto.ProductoDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class detfacturamapper implements RowMapper<DetalleFacturaDTO> {

    public DetalleFacturaDTO mapRow(ResultSet rs, int rownum) throws SQLException {
        DetalleFacturaDTO detalleFacturaDTO = new DetalleFacturaDTO();
        PrecioDTO precioDTO = new PrecioDTO();
        ProductoDTO productoDTO = new ProductoDTO();
        FacturaDTO facturaDTO = new FacturaDTO();

        precioDTO.setNmprecio(rs.getInt("nmprecio"));
        facturaDTO.setNmfactura(rs.getInt("nmfactura"));
        productoDTO.setSku(rs.getInt("sku"));
        detalleFacturaDTO.setNmdetfactura(rs.getInt("nmdetfactura"));
        detalleFacturaDTO.setCantidad(rs.getInt("cantidad"));
        detalleFacturaDTO.setPrecio(rs.getDouble("precio"));
        detalleFacturaDTO.setSku(productoDTO);
        detalleFacturaDTO.setNmprecio(precioDTO);
        detalleFacturaDTO.setNmfactura(facturaDTO);
        return detalleFacturaDTO;
    }

}
