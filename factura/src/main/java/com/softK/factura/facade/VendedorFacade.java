package com.softK.factura.facade;

import com.softK.factura.dao.VendedorDaoInterface;
import com.softK.factura.database.ConexionManager;
import com.softK.factura.dto.VendedorDTO;
import com.softK.factura.exception.FacadeException;
import com.softK.factura.exception.ManagerException;
import com.softK.factura.manager.VendedorManager;
import com.softK.factura.manager.VendedorManagerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Component
@Transactional
public class VendedorFacade implements VendedorFacadeInterface {
    @Autowired
    private VendedorManagerInterface vendedorManagerInterface;

    @Override
    public void save(VendedorDTO vendedorDTO) throws FacadeException {
        try{
            vendedorManagerInterface.save(vendedorDTO);
        }catch (ManagerException e){
            throw new FacadeException(e);
        }catch (Exception e)
        {
            throw new FacadeException(e);
        }
    }

    @Override
    public void delete(VendedorDTO vendedorDTO) throws FacadeException {
        try{
            vendedorManagerInterface.delete(vendedorDTO);
        }catch (ManagerException e){
            throw new FacadeException(e);
        }catch (Exception e){
            throw new FacadeException(e);
        }
    }

    @Override
    public List getAll() throws FacadeException {
        try{
            return vendedorManagerInterface.getAll();
        }catch (ManagerException e){
            throw new FacadeException(e);
        }catch (Exception e){
            throw new FacadeException(e);
        }
    }
}
