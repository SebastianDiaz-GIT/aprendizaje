package com.softK.factura.facade;

import com.softK.factura.dto.ProductoDTO;
import com.softK.factura.exception.FacadeException;
import com.softK.factura.exception.ManagerException;

import java.util.List;

public interface ProductFacadeInterface {

    public void crearProducto(ProductoDTO producto) throws FacadeException;

    public void borrarProducto(ProductoDTO producto) throws FacadeException;

    public List getAll() throws FacadeException;

    List getbyname(ProductoDTO productoDTO) throws ManagerException;
}
