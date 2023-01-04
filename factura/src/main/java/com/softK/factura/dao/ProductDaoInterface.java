package com.softK.factura.dao;

import com.softK.factura.dto.ProductoDTO;
import com.softK.factura.exception.DaoExceptions;

import java.util.List;

public interface ProductDaoInterface {
    public void insert(ProductoDTO producto) throws DaoExceptions;
    public void delete(ProductoDTO producto)  throws DaoExceptions;
    public void update(ProductoDTO producto) throws DaoExceptions;
    public ProductoDTO getbyid(ProductoDTO producto) throws DaoExceptions;
    public List getbyname(ProductoDTO producto) throws DaoExceptions;
    public List getAll() throws DaoExceptions;
}
