package com.softK.factura.facade;

import com.softK.factura.dto.FacturaDTO;
import com.softK.factura.exception.FacadeException;
import com.softK.factura.exception.ManagerException;
import com.softK.factura.manager.FacturaManagerInterfaz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FacturaFacade implements FacturaFacadeInterface{
    @Autowired
    private FacturaManagerInterfaz facturaManagerInterfaz;

    @Override
    public void save(FacturaDTO facturaDTO) throws FacadeException {
        try{
            facturaManagerInterfaz.save(facturaDTO);
        }catch (ManagerException e){
            throw new FacadeException(e);
        }catch (Exception e){
            throw new FacadeException(e);
        }
    }

    @Override
    public void delete(FacturaDTO facturaDTO) throws FacadeException {
        try{
            facturaManagerInterfaz.delete(facturaDTO);
        }catch (ManagerException e){
            throw new FacadeException(e);
        }catch (Exception e){
            throw new FacadeException(e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<FacturaDTO> getall() throws FacadeException {
        try{
            return facturaManagerInterfaz.getall();
        }catch (ManagerException e){
            throw new FacadeException(e);
        }catch (Exception e){
            throw new FacadeException(e);
        }
    }
}
