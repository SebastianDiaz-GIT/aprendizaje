package com.softK.factura.facade;

import com.softK.factura.dto.DetalleFacturaDTO;
import com.softK.factura.exception.FacadeException;
import com.softK.factura.exception.ManagerException;
import com.softK.factura.manager.DetalleFacturaManagerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class DetalleFacturaFacade implements DetalleFacturaFacadeInterface{

    @Autowired
    private DetalleFacturaManagerInterface detalleFacturaManagerInterface;

    @Override
    public void save(DetalleFacturaDTO detalleFacturaDTO) throws FacadeException {
        try{
            detalleFacturaManagerInterface.save(detalleFacturaDTO);
        }catch (ManagerException e){
            throw new FacadeException(e);
        }catch (Exception e){
            throw new FacadeException(e);
        }
    }

    @Override
    public void delete(DetalleFacturaDTO detalleFacturaDTO) throws FacadeException {
        try{
            detalleFacturaManagerInterface.delete(detalleFacturaDTO);
        }catch (ManagerException e){
            throw new FacadeException(e);
        }catch (Exception e){
            throw new FacadeException(e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List getall() throws FacadeException {
        try{
            return detalleFacturaManagerInterface.getall();
        }catch (ManagerException e){
            throw new FacadeException(e);
        }catch (Exception e){
            throw new FacadeException(e);
        }
    }
}
