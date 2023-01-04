package com.softK.factura.manager;

import com.softK.factura.dao.PrecioDaoInterfaz;
import com.softK.factura.dto.PrecioDTO;
import com.softK.factura.exception.DaoExceptions;
import com.softK.factura.exception.ManagerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PrecioManager implements PrecioManagerInterface{

    @Autowired
    private PrecioDaoInterfaz precioDaoInterfaz;

    @Override
    public void save(PrecioDTO precioDTO) throws ManagerException {
        try{
            PrecioDTO preciofound = precioDaoInterfaz.getPreciosById(precioDTO);
            if(preciofound != null){
                precioDaoInterfaz.update(precioDTO);
            }else{
                precioDaoInterfaz.save(precioDTO);
            }
        }catch (DaoExceptions e){
            throw new ManagerException(e);
        }catch (Exception e){
            throw new ManagerException(e);
        }

    }

    @Override
    public void delete(PrecioDTO precioDTO) throws ManagerException {
        try{
            PrecioDTO preciofound = precioDaoInterfaz.getPreciosById(precioDTO);
            if(preciofound != null){
                precioDaoInterfaz.delete(precioDTO);
            }
        }catch (DaoExceptions e){
            throw new ManagerException(e);
        }catch (Exception e){
            throw new ManagerException(e);
        }
    }

    @Override
    public List getPrecios() throws ManagerException {
        try{
            return precioDaoInterfaz.getPrecios();
        }catch (DaoExceptions e){
            throw new ManagerException(e);
        }catch (Exception e){
            throw new ManagerException(e);
        }
    }
}
