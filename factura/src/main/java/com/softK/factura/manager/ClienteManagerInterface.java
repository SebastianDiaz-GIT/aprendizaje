package com.softK.factura.manager;

import com.softK.factura.dto.ClienteDTO;
import com.softK.factura.exception.ManagerException;

import java.util.List;

public interface ClienteManagerInterface {
    public void save(ClienteDTO clienteDTO) throws ManagerException;
    public void delete(ClienteDTO clienteDTO) throws ManagerException;
    public List getAllClientes() throws ManagerException;
}
