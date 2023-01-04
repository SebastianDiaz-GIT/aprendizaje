package com.softK.factura.manager;

import com.softK.factura.dto.FacturaDTO;
import com.softK.factura.dto.PrecioDTO;
import com.softK.factura.exception.ManagerException;

import java.util.List;

public interface FacturaManagerInterfaz {
    public void save(FacturaDTO facturaDTO) throws ManagerException;
    public void delete(FacturaDTO facturaDTO) throws ManagerException;
    public List<FacturaDTO> getall() throws ManagerException;
}
