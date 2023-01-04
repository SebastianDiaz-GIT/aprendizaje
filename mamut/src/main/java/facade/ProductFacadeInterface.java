package facade;

import dto.ProductoDTO;
import exception.FacadeException;

import java.util.List;

public interface ProductFacadeInterface {

    public void crearProducto(ProductoDTO producto) throws FacadeException;

    public void borrarProducto(ProductoDTO producto) throws FacadeException;

    public List getAll() throws FacadeException;
}
