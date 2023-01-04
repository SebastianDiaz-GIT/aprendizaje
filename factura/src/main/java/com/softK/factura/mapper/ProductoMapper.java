package com.softK.factura.mapper;

import com.softK.factura.dto.ProductoDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoMapper implements RowMapper<ProductoDTO> {

    @Override
    public ProductoDTO mapRow(ResultSet rs, int rownum) throws SQLException{
        ProductoDTO productomapper = new ProductoDTO();
        productomapper.setSku(rs.getInt("sku"));
        productomapper.setDsProducto(rs.getString("dsproducto"));
        return productomapper;
    }
}
