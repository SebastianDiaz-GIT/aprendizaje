package com.softK.factura.facade;

import com.softK.factura.dto.DetalleFacturaDTO;
import com.softK.factura.dto.FacturaDTO;
import com.softK.factura.exception.FacadeException;

import java.util.List;

public interface DetalleFacturaFacadeInterface {

    public void save(DetalleFacturaDTO detalleFacturaDTO) throws FacadeException;
    public void delete(DetalleFacturaDTO detalleFacturaDTO) throws FacadeException;
    public List getall() throws FacadeException;

}
