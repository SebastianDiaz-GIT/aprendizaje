package com.softK.factura.facade;

import com.softK.factura.dto.FacturaDTO;
import com.softK.factura.dto.PrecioDTO;
import com.softK.factura.exception.FacadeException;

import java.util.List;

public interface FacturaFacadeInterface {

    public void save(FacturaDTO facturaDTO) throws FacadeException;
    public void delete(FacturaDTO facturaDTO) throws FacadeException;
    public List<FacturaDTO> getall() throws FacadeException;

}
