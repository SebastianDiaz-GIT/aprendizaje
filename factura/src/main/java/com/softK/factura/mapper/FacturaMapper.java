package com.softK.factura.mapper;

import com.softK.factura.dto.ClienteDTO;
import com.softK.factura.dto.FacturaDTO;
import com.softK.factura.dto.VendedorDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FacturaMapper implements RowMapper<FacturaDTO> {

    public FacturaDTO mapRow(ResultSet rs, int rownum) throws SQLException {
        FacturaDTO facturamapper = new FacturaDTO();
        ClienteDTO clientedto = new ClienteDTO();
        VendedorDTO vendedordto = new VendedorDTO();

        facturamapper.setNmfactura(rs.getInt("nmfactura"));
        facturamapper.setCdfactura(rs.getString("cdfactura"));
        facturamapper.setFefactura(rs.getDate("fecha_factura"));
        facturamapper.setNmcliente(clientedto);
        facturamapper.setNmvendedor(vendedordto);

        clientedto.setNmCliente(rs.getInt("nmcliente"));
        clientedto.setDocumento(rs.getInt("documento"));
        clientedto.setDsNombres(rs.getString("dsnombre"));
        clientedto.setDsApellidos(rs.getString("dsapellido"));
        clientedto.setDsDireccion(rs.getString("dsdireccion"));

        vendedordto.setNmvendedor(rs.getInt("nmvendedor"));
        vendedordto.setDocumentov(rs.getString("documentov"));
        vendedordto.setDsvnombre(rs.getString("dsvnombre"));
        vendedordto.setDsvapellido(rs.getString("dsvapellido"));
        vendedordto.setDsvdireccion(rs.getString("dsvdireccion"));


        return facturamapper;
    }

}
