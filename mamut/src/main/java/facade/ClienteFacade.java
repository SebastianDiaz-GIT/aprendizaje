package facade;

import basedatos.ConexionManager;
import dto.ClienteDTO;
import exception.FacadeException;
import exception.ManagerException;
import manager.ClienteManager;
import manager.ClienteManagerInterface;

public class ClienteFacade implements ClienteFacadeInt {

    private ClienteManagerInterface clienteManagerInterface;
    public ClienteFacade(){
        clienteManagerInterface = new ClienteManager();
    }

    @Override
    public void crear(ClienteDTO clienteDTO) throws FacadeException {
        ConexionManager.getInstance().open();
        try{
            clienteManagerInterface.save(clienteDTO);
            ConexionManager.getInstance().commit();
        }catch(ManagerException e){
            ConexionManager.getInstance().rollback();
            throw new FacadeException(e);
        }catch (Exception ex)
        {
            ConexionManager.getInstance().rollback();
            throw new FacadeException(ex);
        }finally {
            ConexionManager.getInstance().close();
        }
    }

    @Override
    public void delete(ClienteDTO clienteDTO) throws FacadeException {

    }

    @Override
    public void getAll() {

    }
}
