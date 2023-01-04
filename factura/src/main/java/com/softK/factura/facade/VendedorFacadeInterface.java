package com.softK.factura.facade;

import com.softK.factura.dto.VendedorDTO;
import com.softK.factura.exception.FacadeException;
import com.softK.factura.exception.ManagerException;

import java.util.List;

public interface VendedorFacadeInterface {
    public void save(VendedorDTO vendedorDTO) throws FacadeException;
    public void delete(VendedorDTO vendedorDTO) throws FacadeException;
    public List getAll() throws FacadeException;
}
