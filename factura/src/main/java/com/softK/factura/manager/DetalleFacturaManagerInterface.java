package com.softK.factura.manager;

import com.softK.factura.dto.DetalleFacturaDTO;
import com.softK.factura.dto.PrecioDTO;
import com.softK.factura.exception.ManagerException;

import java.util.List;

public interface DetalleFacturaManagerInterface {
    public void save(DetalleFacturaDTO detalleFacturaDTO) throws ManagerException;
    public void delete(DetalleFacturaDTO detalleFacturaDTO) throws ManagerException;
    public List getall() throws ManagerException;
}
