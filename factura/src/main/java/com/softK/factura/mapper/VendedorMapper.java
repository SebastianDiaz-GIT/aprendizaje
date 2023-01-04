package com.softK.factura.mapper;

import com.softK.factura.dto.VendedorDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VendedorMapper implements RowMapper<VendedorDTO> {
    public VendedorDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        VendedorDTO vendedormapper= new VendedorDTO();
        vendedormapper.setNmvendedor(rs.getInt("nmvendedor"));
        vendedormapper.setDocumentov(rs.getString("documentov"));
        vendedormapper.setDsvnombre(rs.getString("dsvnombre"));
        vendedormapper.setDsvapellido(rs.getString("dsvapellido"));
        vendedormapper.setDsvdireccion(rs.getString("dsvdireccion"));
        return vendedormapper;
    }
}
