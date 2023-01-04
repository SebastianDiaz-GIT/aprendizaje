package facade;

import basedatos.ConexionManager;
import dao.ProductoDAO;
import dto.ProductoDTO;
import exception.DaoExceptions;
import exception.FacadeException;
import exception.ManagerException;
import manager.ProductManagerInterface;
import manager.ProductoManager;

import java.sql.ResultSet;
import java.util.List;

public class ProductoFacade implements ProductFacadeInterface{

    private ProductManagerInterface productoManager;

    public ProductoFacade()
    {
        productoManager = new ProductoManager();
    }

    public void crearProducto(ProductoDTO producto) throws FacadeException
    {
        ConexionManager.getInstance().open();
        try{
            productoManager.save(producto);
            ConexionManager.getInstance().commit();

        }catch (ManagerException ex){
            ConexionManager.getInstance().rollback();
            throw new FacadeException(ex);
        }catch (Exception e)
        {
            ConexionManager.getInstance().rollback();
            throw new FacadeException(e);
        }finally {
            ConexionManager.getInstance().close();
        }
    }

    public void borrarProducto(ProductoDTO producto) throws FacadeException
    {
        ConexionManager.getInstance().open();
        try{
            productoManager.delete(producto);
            ConexionManager.getInstance().commit();
        }catch (ManagerException ex){
            ConexionManager.getInstance().rollback();
            throw new FacadeException(ex);
        }catch (Exception e)
        {
            ConexionManager.getInstance().rollback();
            throw new FacadeException(e);
        }
    }

    public List getAll() throws FacadeException{
        ConexionManager conexionManager = ConexionManager.getInstance();
        conexionManager.open();

        try{
            return productoManager.getAll();
        }catch (ManagerException ex){
            throw new FacadeException(ex);
        }catch (Exception e)
        {
            throw new FacadeException(e);
        }
    }
}
