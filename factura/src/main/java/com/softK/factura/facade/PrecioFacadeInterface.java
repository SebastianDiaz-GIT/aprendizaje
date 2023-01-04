package com.softK.factura.facade;

import com.softK.factura.dto.PrecioDTO;
import com.softK.factura.exception.FacadeException;

import java.util.List;

public interface PrecioFacadeInterface {
    public void save(PrecioDTO precioDTO) throws FacadeException;
    public void delete(PrecioDTO precioDTO) throws FacadeException;
    public List getPrecios() throws FacadeException;
}
