package controller;

import dto.ClienteDTO;
import exception.ControllerException;
import exception.FacadeException;
import facade.ClienteFacade;
import facade.ClienteFacadeInt;

public class ClienteController implements ClienteControllerInterface{

    private ClienteFacadeInt clienteFacade;

    public ClienteController()
    {
        clienteFacade = new ClienteFacade();
    }
    @Override
    public void crearCliente(ClienteDTO clienteDTO) throws ControllerException {
        try{
            clienteFacade.crear(clienteDTO);
        }catch (FacadeException e)
        {
            throw new ControllerException(e);
        }catch (Exception e)
        {
            throw new ControllerException(e);
        }
    }

    @Override
    public void borrarCliente(ClienteDTO clienteDTO) throws ControllerException {

    }

    @Override
    public void getAll() throws ControllerException {

    }
}
