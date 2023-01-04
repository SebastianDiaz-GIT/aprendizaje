package controller;

import dto.ClienteDTO;
import exception.ControllerException;

public interface ClienteControllerInterface {
    public void crearCliente(ClienteDTO clienteDTO) throws ControllerException;
    public void borrarCliente(ClienteDTO clienteDTO) throws ControllerException;
    public void getAll() throws ControllerException;
}
