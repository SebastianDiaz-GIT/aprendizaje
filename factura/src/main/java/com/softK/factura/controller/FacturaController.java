package com.softK.factura.controller;

import com.softK.factura.dto.FacturaDTO;
import com.softK.factura.exception.ControllerException;
import com.softK.factura.exception.FacadeException;
import com.softK.factura.facade.FacturaFacade;
import com.softK.factura.facade.FacturaFacadeInterface;
import com.softK.factura.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/factura")
public class FacturaController {

    @Autowired
    private FacturaFacadeInterface facturaFacadeInterface;


    @PostMapping("/crear-factura")
    public ResponseEntity<Message> crarFactura(@RequestBody FacturaDTO facturaDTO) throws ControllerException {
        Message message = new Message("0", "Successful Create", null);
        try {
            facturaFacadeInterface.save(facturaDTO);
        }catch (FacadeException e){
            throw new ControllerException(e);
        }
        return ResponseEntity.ok(message);
    }


    @PostMapping("/delete-factura")
    public ResponseEntity<Message> delete(@RequestBody  FacturaDTO facturaDTO) throws ControllerException {
        Message message = new Message("0", "Successful delete", null);
        try {
            facturaFacadeInterface.delete(facturaDTO);
        }catch (FacadeException e){
            throw new ControllerException(e);
        }
        return ResponseEntity.ok(message);
    }

    @GetMapping("/getall-facturas")
    public ResponseEntity<Message> getall() throws ControllerException {
        Message message = new Message("0", "Successful get all found", null);
        try {
            List<FacturaDTO> list = facturaFacadeInterface.getall();
            message.setData(list);
        }catch (FacadeException e){
            message.setMessage("Error en el controlador");
            message.setCodigo("1");
            throw new ControllerException(e);
        }
        return ResponseEntity.ok(message);
    }
}
