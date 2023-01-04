package com.softK.factura.dao;

import com.softK.factura.dto.FacturaDTO;
import com.softK.factura.exception.DaoExceptions;

import java.util.List;

public interface FacturaDaoInterfaz {
    public void save(FacturaDTO facturaDTO) throws DaoExceptions;
    public void update(FacturaDTO facturaDTO) throws DaoExceptions;
    public void delete(FacturaDTO facturaDTO) throws DaoExceptions;
    public List<FacturaDTO> getall() throws DaoExceptions;
    public FacturaDTO getbyid(FacturaDTO facturaDTO) throws DaoExceptions;
}
