package com.softK.factura.manager;


import com.softK.factura.dao.ClienteDAO;
import com.softK.factura.dao.ClienteDaoInterfaz;
import com.softK.factura.dto.ClienteDTO;
import com.softK.factura.exception.DaoExceptions;
import com.softK.factura.exception.ManagerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ClienteManager implements ClienteManagerInterface{
    @Autowired
    private ClienteDaoInterfaz clienteDAO;
    /*
    public ClienteManager()
    {
        clienteDAO = new ClienteDAO();
    }

     */
    @Override
    public void save(ClienteDTO clienteDTO) throws ManagerException
    {
        try
        {
            ClienteDTO clientefound = clienteDAO.getById(clienteDTO);
            if(clientefound != null)
            {
                clienteDAO.update(clienteDTO);
            }else {
                clienteDAO.insert(clienteDTO);
            }
        }catch (DaoExceptions ex){
            throw new ManagerException(ex);
        }catch (Exception e)
        {
            throw new ManagerException(e);
        }

    }

    @Override
    public void delete(ClienteDTO clienteDTO)  throws ManagerException
    {
        try {
            System.out.println(clienteDTO.getNmCliente());
            ClienteDTO clientefound = clienteDAO.getById(clienteDTO);
            if(clientefound != null){
                clienteDAO.delete(clienteDTO);
            }
        }catch (Exception e)
        {
            throw new ManagerException(e);
        }
    }

    @Override
    public List getAllClientes() throws ManagerException {
        try
        {
            return clienteDAO.getAll();
        }catch (DaoExceptions ex){
            throw new ManagerException(ex);
        }catch (Exception e)
        {
            throw new ManagerException(e);
        }
    }
}
