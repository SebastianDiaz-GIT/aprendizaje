package com.softK.factura.manager;

import com.softK.factura.dao.FacturaDaoInterfaz;
import com.softK.factura.dao.VendedorDaoInterface;
import com.softK.factura.dto.FacturaDTO;
import com.softK.factura.exception.DaoExceptions;
import com.softK.factura.exception.ManagerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class FacturaManager implements FacturaManagerInterfaz{
    @Autowired
    private FacturaDaoInterfaz daoInterface;

    @Override
    public void save(FacturaDTO facturaDTO) throws ManagerException {
        try{
            FacturaDTO facturafound = daoInterface.getbyid(facturaDTO);
            if (facturafound != null){
                daoInterface.update(facturaDTO);
            }else{
                daoInterface.save(facturaDTO);
            }

        }catch (DaoExceptions e){
            throw new ManagerException(e);
        }catch (Exception e){
            throw new ManagerException(e);
        }
    }

    @Override
    public void delete(FacturaDTO facturaDTO) throws ManagerException {
        try{
            FacturaDTO facturafound = daoInterface.getbyid(facturaDTO);
            if (facturafound != null){
                daoInterface.delete(facturaDTO);
            }

        }catch (DaoExceptions e){
            throw new ManagerException(e);
        }catch (Exception e){
            throw new ManagerException(e);
        }
    }

    @Override
    public List<FacturaDTO> getall() throws ManagerException {
        try{
            return daoInterface.getall();
        }catch (DaoExceptions e){
            throw new ManagerException(e);
        }catch (Exception e){
            throw new ManagerException(e);
        }
    }
}
