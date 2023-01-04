package com.softK.factura.controller;


import com.softK.factura.dto.ClienteDTO;
import com.softK.factura.exception.ControllerException;
import com.softK.factura.exception.FacadeException;
import com.softK.factura.facade.ClienteFacade;
import com.softK.factura.facade.ClienteFacadeInt;
import com.softK.factura.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api-cliente")
public class ClienteController {
    @Autowired
    private ClienteFacadeInt clienteFacade;


    /*
    public ClienteController()
    {
        clienteFacade = new ClienteFacade();
    }

     */

    @PostMapping("/crearCliente")
    public ResponseEntity<Message> crearCliente(@RequestBody ClienteDTO clienteDTO) throws ControllerException {
        Message message = new Message("0", "Creacion Exitosa", null);
        try{
            clienteFacade.crear(clienteDTO);
        }catch (FacadeException e)
        {
            message.setCodigo("1");
            message.setMessage("Error en crear un producto"+e.getMessage());
            throw new ControllerException(e);
        }catch (Exception e)
        {
            throw new ControllerException(e);
        }
        return ResponseEntity.ok(message);
    }

    @PostMapping("/delete-cliente")
    public ResponseEntity<Message> borrarCliente(@RequestBody ClienteDTO clienteDTO) throws ControllerException {
        Message message = new Message("0", "Delete Successful", null);

        try{
            clienteFacade.delete(clienteDTO);
        }catch (FacadeException e){
            throw new ControllerException(e);
        }catch (Exception e){
            throw new ControllerException(e);
        }
        return ResponseEntity.ok(message);
    }

    @GetMapping("/getclientes")
    public ResponseEntity<Message> getAll() throws ControllerException {
        Message message = new Message("0", "Get All Successful", null);

        try{
            List<ClienteDTO> clientList = clienteFacade.getAll();
            message.setData(clientList);
        }catch (FacadeException e){
            message.setCodigo("1");
            message.setMessage("Get All Error" + e.getMessage());
            throw new ControllerException(e);
        }catch (Exception e)
        {
            message.setCodigo("1");
            message.setMessage("Error en getAll producto"+e.getMessage());
            throw new ControllerException(e);
        }
        return ResponseEntity.ok(message);
    }
}
