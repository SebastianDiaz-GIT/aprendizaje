package com.softK.factura.dao;

import com.softK.factura.dto.ClienteDTO;
import com.softK.factura.dto.VendedorDTO;
import com.softK.factura.exception.DaoExceptions;

import java.util.List;

public interface VendedorDaoInterface {
    public void insert(VendedorDTO vendedorDTO) throws DaoExceptions;
    public void delete(VendedorDTO vendedorDTO) throws DaoExceptions;
    public void update(VendedorDTO vendedorDTO) throws DaoExceptions;
    public List getAll() throws DaoExceptions;

    public VendedorDTO getById(VendedorDTO vendedorDTO) throws DaoExceptions;
}
