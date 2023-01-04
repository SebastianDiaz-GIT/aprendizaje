package com.softK.factura.manager;

import com.softK.factura.dao.VendedorDaoInterface;
import com.softK.factura.dto.VendedorDTO;
import com.softK.factura.exception.DaoExceptions;
import com.softK.factura.exception.ManagerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class VendedorManager implements VendedorManagerInterface {
    @Autowired
    private VendedorDaoInterface vendedorDaoInterface;
    @Override
    public void save(VendedorDTO vendedorDTO) throws ManagerException {
        try{
            VendedorDTO vendedorfound = vendedorDaoInterface.getById(vendedorDTO);
            if(vendedorfound != null)
            {
                vendedorDaoInterface.update(vendedorDTO);
            }else{
                vendedorDaoInterface.insert(vendedorDTO);
            }
        }catch (DaoExceptions e){
            throw new ManagerException(e);
        }
    }

    @Override
    public void delete(VendedorDTO vendedorDTO) throws ManagerException {
        try{
            VendedorDTO vendedorfound = vendedorDaoInterface.getById(vendedorDTO);
            if(vendedorfound != null)
            {
                vendedorDaoInterface.delete(vendedorDTO);
            }else {
                throw new ManagerException("Vendedor al eliminar no existe");
            }
        }catch (DaoExceptions exceptions){
            throw new ManagerException(exceptions);
        }
    }

    @Override
    public List getAll() throws ManagerException {
        try{
            return vendedorDaoInterface.getAll();
        }catch (DaoExceptions exceptions){
            throw new ManagerException(exceptions);
        }
    }
}
