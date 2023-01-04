package com.softK.factura.manager;

import com.softK.factura.dto.VendedorDTO;
import com.softK.factura.exception.DaoExceptions;
import com.softK.factura.exception.ManagerException;

import java.util.List;

public interface VendedorManagerInterface {
    public void save(VendedorDTO vendedorDTO) throws ManagerException;
    public void delete(VendedorDTO vendedorDTO) throws ManagerException;
    public List getAll() throws ManagerException;
}
