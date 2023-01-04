package com.softK.factura.mapper;

import com.softK.factura.dto.ClienteDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteMapper implements RowMapper<ClienteDTO> {
    public ClienteDTO mapRow(ResultSet rs, int rownum) throws SQLException {
        ClienteDTO clientemapper = new ClienteDTO();
        clientemapper.setNmCliente(rs.getInt("nmcliente"));
        clientemapper.setDocumento(rs.getInt("documento"));
        clientemapper.setDsNombres(rs.getString("dsnombre"));
        clientemapper.setDsApellidos(rs.getString("dsapellido"));
        clientemapper.setDsDireccion(rs.getString("dsdireccion"));
        return clientemapper;
    }
}
