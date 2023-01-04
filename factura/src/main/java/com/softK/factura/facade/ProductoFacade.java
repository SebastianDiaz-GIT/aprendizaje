package com.softK.factura.facade;

import com.softK.factura.database.ConexionManager;
import com.softK.factura.dto.ProductoDTO;
import com.softK.factura.exception.FacadeException;
import com.softK.factura.exception.ManagerException;
import com.softK.factura.manager.ProductManagerInterface;
import com.softK.factura.manager.ProductoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Component
@Transactional //maneja las transacciones ... rollback y commit
public class ProductoFacade implements ProductFacadeInterface{

    @Autowired
    private ProductManagerInterface productoManager;

    public void crearProducto(ProductoDTO producto) throws FacadeException
    {
        try{
            productoManager.save(producto);
        }catch (ManagerException ex){
            throw new FacadeException(ex);
        }catch (Exception e)
        {
            throw new FacadeException(e);
        }
    }

    public void borrarProducto(ProductoDTO producto) throws FacadeException
    {

        try{
            productoManager.delete(producto);
        }catch (ManagerException ex){
            throw new FacadeException(ex);
        }catch (Exception e)
        {
            throw new FacadeException(e);
        }
    }

    @Transactional(readOnly = true) // solo lectura query
    public List getAll() throws FacadeException{
        try{
            return productoManager.getAll();
        }catch (ManagerException ex){
            throw new FacadeException(ex);
        }catch (Exception e)
        {
            throw new FacadeException(e);
        }
    }

    @Override
    public List getbyname(ProductoDTO productoDTO) throws ManagerException {
        try{
            return productoManager.getbyname(productoDTO);
        }catch (ManagerException ex){
            throw new FacadeException(ex);
        }catch (Exception e)
        {
            throw new FacadeException(e);
        }
    }
}
