package manager;

import dto.ProductoDTO;
import exception.ManagerException;

import java.util.List;

public interface ProductManagerInterface {
    public void save(ProductoDTO producto) throws ManagerException;
    public void delete(ProductoDTO producto) throws ManagerException;
    public List getAll() throws ManagerException;

}

