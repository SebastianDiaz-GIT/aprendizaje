package com.softK.factura.facade;

import com.softK.factura.dto.PrecioDTO;
import com.softK.factura.exception.FacadeException;
import com.softK.factura.exception.ManagerException;
import com.softK.factura.manager.PrecioManagerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class PrecioFacade implements PrecioFacadeInterface{

    @Autowired
    private PrecioManagerInterface precioManagerInterface;

    @Override
    public void save(PrecioDTO precioDTO) throws FacadeException {
        try{
            precioManagerInterface.save(precioDTO);
        }catch (ManagerException e){
            throw new FacadeException(e);
        }catch (Exception e){
            throw new FacadeException(e);
        }
    }

    @Override
    public void delete(PrecioDTO precioDTO) throws FacadeException {
        try{
            precioManagerInterface.delete(precioDTO);
        }catch (ManagerException e){
            throw new FacadeException(e);
        }catch (Exception e){
            throw new FacadeException(e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List getPrecios() throws FacadeException {
        try{
            return precioManagerInterface.getPrecios();
        }catch (ManagerException e){
            throw new FacadeException(e);
        }catch (Exception e){
            throw new FacadeException(e);
        }
    }
}
