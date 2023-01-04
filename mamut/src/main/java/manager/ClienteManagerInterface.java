package manager;

import dto.ClienteDTO;
import exception.ManagerException;

public interface ClienteManagerInterface {
    public void save(ClienteDTO clienteDTO) throws ManagerException;
    public void delete(ClienteDTO clienteDTO) throws ManagerException;

}
