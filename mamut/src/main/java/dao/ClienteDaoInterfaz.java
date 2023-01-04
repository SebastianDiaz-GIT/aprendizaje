package dao;

import dto.ClienteDTO;
import exception.DaoExceptions;

public interface ClienteDaoInterfaz {

    public void insert(ClienteDTO clienteDTO) throws DaoExceptions;
    public void delete(ClienteDTO clienteDTO) throws DaoExceptions;
    public void update(ClienteDTO clienteDTO) throws DaoExceptions;
    public void getall() throws DaoExceptions;

    public int getById(ClienteDTO clienteDTO) throws DaoExceptions;
}
