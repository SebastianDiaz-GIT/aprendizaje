package dao;

import dto.ProductoDTO;
import exception.DaoExceptions;

import java.util.List;

public interface ProducDaoInterface {
    public void insert(ProductoDTO producto) throws DaoExceptions;
    public void delete(ProductoDTO producto)  throws DaoExceptions;
    public void update(ProductoDTO producto) throws DaoExceptions;
    public int count(ProductoDTO producto) throws DaoExceptions;
    public List getAll() throws DaoExceptions;
}