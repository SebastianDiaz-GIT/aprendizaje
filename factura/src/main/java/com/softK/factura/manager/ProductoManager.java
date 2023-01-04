package com.softK.factura.manager;

import com.softK.factura.dao.ProductDaoInterface;
import com.softK.factura.dao.ProductoDAO;
import com.softK.factura.dto.ProductoDTO;
import com.softK.factura.exception.DaoExceptions;
import com.softK.factura.exception.ManagerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductoManager implements ProductManagerInterface{

    @Autowired
    private ProductDaoInterface productoDAO;

    /*
    public ProductoManager( ) {
        productoDAO = new ProductoDAO();
    }*/

    @Override
    public void save(ProductoDTO producto) throws ManagerException
    {
        try
        {
            ProductoDTO productfound = productoDAO.getbyid(producto);
            if(productfound != null)
            {
                productoDAO.update(producto);
            }else {
                productoDAO.insert(producto);
            }
        }catch (DaoExceptions ex){
            throw new ManagerException(ex);
        }catch (Exception e)
        {
            throw new ManagerException(e);
        }



    }

    @Override
    public void delete(ProductoDTO producto) throws ManagerException
    {
        try
        {
            ProductoDTO productfound = productoDAO.getbyid(producto);
            if(productfound != null )
            {
                productoDAO.delete(producto);
            }

        }catch (DaoExceptions ex){
            throw new ManagerException(ex);
        }catch (Exception e)
        {
            throw new ManagerException(e);
        }

    }

    @Override
    public List getAll() throws ManagerException {
        try{
            return productoDAO.getAll();
        }catch (DaoExceptions ex){
            throw new ManagerException(ex);
        }catch (Exception e)
        {
            throw new ManagerException(e);
        }
    }

    @Override
    public List getbyname(ProductoDTO productoDTO) throws ManagerException {
        try{
            return productoDAO.getbyname(productoDTO);
        }catch (DaoExceptions ex){
            throw new ManagerException(ex);
        }catch (Exception e)
        {
            throw new ManagerException(e);
        }
    }
}
