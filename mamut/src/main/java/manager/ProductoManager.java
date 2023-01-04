package manager;

import dao.ProducDaoInterface;
import dao.ProductoDAO;
import dto.ProductoDTO;
import exception.ControllerException;
import exception.DaoExceptions;
import exception.ManagerException;

import java.util.List;

public class ProductoManager implements ProductManagerInterface{

    private ProducDaoInterface productoDAO;

    public ProductoManager()
    {
        productoDAO = new ProductoDAO();
    }

    public void save(ProductoDTO producto) throws ManagerException
    {
        try
        {
            int count = productoDAO.count(producto);
            if(count > 0)
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

    public void delete(ProductoDTO producto) throws ManagerException
    {
        try
        {
            int count = productoDAO.count(producto);
            if(count >0 )
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
}
