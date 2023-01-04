package com.softK.factura.dao;

import com.softK.factura.dto.DetalleFacturaDTO;
import com.softK.factura.exception.DaoExceptions;

import java.util.List;

public interface FacturaDetalleDaoInterface {

    void crear(DetalleFacturaDTO detalleFacturaDTO) throws DaoExceptions;
    void delete(DetalleFacturaDTO detalleFacturaDTO)throws DaoExceptions;
    void update(DetalleFacturaDTO detalleFacturaDTO) throws  DaoExceptions;
    DetalleFacturaDTO getbyid(DetalleFacturaDTO detalleFacturaDTO)throws DaoExceptions;
    List getall() throws DaoExceptions;


}
