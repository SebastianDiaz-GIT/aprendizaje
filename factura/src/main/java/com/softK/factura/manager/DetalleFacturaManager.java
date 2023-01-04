package com.softK.factura.manager;

import com.softK.factura.dao.FacturaDetalleDaoInterface;
import com.softK.factura.dto.DetalleFacturaDTO;
import com.softK.factura.exception.DaoExceptions;
import com.softK.factura.exception.ManagerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DetalleFacturaManager implements DetalleFacturaManagerInterface{
    @Autowired
    private FacturaDetalleDaoInterface facturaDetalleDaoInterface;

    @Override
    public void save(DetalleFacturaDTO detalleFacturaDTO) throws ManagerException {
        try{
            DetalleFacturaDTO dtfacturafound = facturaDetalleDaoInterface.getbyid(detalleFacturaDTO);
            if(dtfacturafound != null){
                facturaDetalleDaoInterface.update(detalleFacturaDTO);
            }else{
                facturaDetalleDaoInterface.crear(detalleFacturaDTO);
            }
        }catch (DaoExceptions e){
            throw new ManagerException(e);
        }catch (Exception e){
            throw new ManagerException(e);
        }
    }

    @Override
    public void delete(DetalleFacturaDTO detalleFacturaDTO) throws ManagerException {
        try{
            DetalleFacturaDTO dtfacturafound = facturaDetalleDaoInterface.getbyid(detalleFacturaDTO);
            if(dtfacturafound != null){
                facturaDetalleDaoInterface.delete(detalleFacturaDTO);
            }
        }catch (DaoExceptions e){
            throw new ManagerException(e);
        }catch (Exception e){
            throw new ManagerException(e);
        }
    }

    @Override
    public List getall() throws ManagerException {
        try{
            return facturaDetalleDaoInterface.getall();
        }catch (DaoExceptions e){
            throw new ManagerException(e);
        }catch (Exception e){
            throw new ManagerException(e);
        }
    }
}
