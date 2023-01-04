package controller;

import dto.ProductoDTO;
import exception.ControllerException;
import exception.DaoExceptions;
import exception.FacadeException;
import facade.ProductFacadeInterface;
import facade.ProductoFacade;

import java.sql.Connection;
import java.util.List;

public class ProductoController implements ProducControllerInterface{

    private ProductFacadeInterface productoFacade;

    public ProductoController()
    {
        productoFacade = new ProductoFacade();
    }

    public void crearProducto(ProductoDTO producto) throws ControllerException
    {
        try{
            productoFacade.crearProducto(producto);
        }catch (FacadeException ex){
            throw new ControllerException(ex);
        }catch (Exception e)
        {
            throw new ControllerException(e);
        }

    }

    public void borrarProducto(ProductoDTO producto) throws ControllerException
    {
        try{
            productoFacade.borrarProducto(producto);
        }catch (FacadeException ex){
            throw new ControllerException(ex);
        }catch (Exception e)
        {
            throw new ControllerException(e);
        }
    }

    public List getAll() throws ControllerException{
        try{
            return productoFacade.getAll();
        }catch (FacadeException ex){
            throw new ControllerException(ex);
        }catch (Exception e)
        {
            throw new ControllerException(e);
        }
    }
}
