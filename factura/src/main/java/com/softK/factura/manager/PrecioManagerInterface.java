package com.softK.factura.manager;

import com.softK.factura.dto.PrecioDTO;
import com.softK.factura.exception.ManagerException;

import java.util.List;

public interface PrecioManagerInterface {
    public void save(PrecioDTO precioDTO) throws ManagerException;
    public void delete(PrecioDTO precioDTO) throws ManagerException;
    public List getPrecios() throws ManagerException;

}
