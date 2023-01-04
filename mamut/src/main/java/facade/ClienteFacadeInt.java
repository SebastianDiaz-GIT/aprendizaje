package facade;

import dto.ClienteDTO;
import exception.FacadeException;

public interface ClienteFacadeInt {
    public void crear(ClienteDTO clienteDTO) throws FacadeException;
    public void delete(ClienteDTO clienteDTO) throws FacadeException;
    public void getAll();
}
