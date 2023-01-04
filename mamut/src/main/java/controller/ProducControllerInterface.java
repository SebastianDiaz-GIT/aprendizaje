package controller;

import dto.ProductoDTO;
import exception.ControllerException;

import java.util.List;

public interface ProducControllerInterface {
    public void crearProducto(ProductoDTO producto) throws ControllerException;
    public void borrarProducto(ProductoDTO producto) throws ControllerException;
    public List getAll() throws ControllerException;
}
