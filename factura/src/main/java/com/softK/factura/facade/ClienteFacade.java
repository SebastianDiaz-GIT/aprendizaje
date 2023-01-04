package com.softK.factura.facade;

import com.softK.factura.database.ConexionManager;
import com.softK.factura.dto.ClienteDTO;
import com.softK.factura.exception.FacadeException;
import com.softK.factura.exception.ManagerException;
import com.softK.factura.manager.ClienteManager;
import com.softK.factura.manager.ClienteManagerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Component
@Transactional
public class ClienteFacade implements ClienteFacadeInt {
    @Autowired
    private ClienteManagerInterface clienteManagerInterface;

    @Override
    public void crear(ClienteDTO clienteDTO) throws FacadeException {

        try{
            clienteManagerInterface.save(clienteDTO);
        }catch(ManagerException e){
            throw new FacadeException(e);
        }catch (Exception ex)
        {
            throw new FacadeException(ex);
        }
    }

    @Override
    public void delete(ClienteDTO clienteDTO) throws FacadeException {

        try{
            clienteManagerInterface.delete(clienteDTO);
        }catch (Exception e){
            throw new FacadeException(e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List getAll() throws FacadeException{
        try{
            return clienteManagerInterface.getAllClientes();
        }catch (ManagerException e){

            throw new FacadeException(e);
        }catch (Exception ex){
            throw new FacadeException(ex);
        }
    }
}
