package com.softK.factura.dao;

import com.softK.factura.dto.PrecioDTO;
import com.softK.factura.exception.DaoExceptions;

import java.util.List;

public interface PrecioDaoInterfaz {
    public void save(PrecioDTO precioDTO) throws DaoExceptions;
    public void update(PrecioDTO precioDTO)throws DaoExceptions;
    public void delete(PrecioDTO precioDTO)throws DaoExceptions;
    public PrecioDTO getPreciosById(PrecioDTO precioDTO)throws DaoExceptions;
    public List getPrecios()throws DaoExceptions;

}
