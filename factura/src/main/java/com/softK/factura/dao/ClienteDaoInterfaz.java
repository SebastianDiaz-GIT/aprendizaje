package com.softK.factura.dao;

import com.softK.factura.dto.ClienteDTO;
import com.softK.factura.exception.DaoExceptions;

import java.util.List;

public interface ClienteDaoInterfaz {

    public void insert(ClienteDTO clienteDTO) throws DaoExceptions;
    public void delete(ClienteDTO clienteDTO) throws DaoExceptions;
    public void update(ClienteDTO clienteDTO) throws DaoExceptions;
    public List getAll() throws DaoExceptions;

    public ClienteDTO getById(ClienteDTO clienteDTO) throws DaoExceptions;
}
