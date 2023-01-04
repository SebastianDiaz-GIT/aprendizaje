package com.softK.factura.manager;

import com.softK.factura.dto.ProductoDTO;
import com.softK.factura.exception.ManagerException;


import java.util.List;

public interface ProductManagerInterface {
    public void save(ProductoDTO producto) throws ManagerException;
    public void delete(ProductoDTO producto) throws ManagerException;
    public List getAll() throws ManagerException;

    List getbyname(ProductoDTO productoDTO) throws ManagerException;


}

