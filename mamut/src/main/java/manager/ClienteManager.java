package manager;

import dao.ClienteDAO;
import dao.ClienteDaoInterfaz;
import dto.ClienteDTO;
import exception.DaoExceptions;
import exception.ManagerException;

public class ClienteManager implements ClienteManagerInterface{
    private ClienteDaoInterfaz clienteDAO;

    public ClienteManager()
    {
        clienteDAO = new ClienteDAO();
    }

    public void save(ClienteDTO clienteDTO) throws ManagerException
    {
        try
        {
            int count = clienteDAO.getById(clienteDTO);
            if(count > 0)
            {
                clienteDAO.update(clienteDTO);
            }else {
                clienteDAO.insert(clienteDTO);
            }
        }catch (DaoExceptions ex){
            throw new ManagerException(ex);
        }catch (Exception e)
        {
            throw new ManagerException(e);
        }

    }

    public void delete(ClienteDTO clienteDTO)  throws ManagerException
    {

    }
}
