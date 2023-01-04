package com.softK.factura.facade;


import com.softK.factura.dto.ClienteDTO;
import com.softK.factura.exception.FacadeException;

import java.util.List;

public interface ClienteFacadeInt {
    public void crear(ClienteDTO clienteDTO) throws FacadeException;
    public void delete(ClienteDTO clienteDTO) throws FacadeException;
    public List getAll() throws FacadeException;
}
