package com.softK.factura.controller;

import com.softK.factura.dto.DetalleFacturaDTO;
import com.softK.factura.exception.ControllerException;
import com.softK.factura.exception.FacadeException;
import com.softK.factura.facade.DetalleFacturaFacadeInterface;
import com.softK.factura.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/detalle-factura")
public class DetalleFacturaController {
    @Autowired
    private DetalleFacturaFacadeInterface detalleFacturaFacadeInterface;

    @PostMapping("/save")
    public ResponseEntity<Message> save(@RequestBody DetalleFacturaDTO detalleFacturaDTO) throws ControllerException {
        Message message = new Message("0", "Creacion Exitosa", null);
        try{
            detalleFacturaFacadeInterface.save(detalleFacturaDTO);
        }catch (FacadeException e){
            message.setCodigo("1");
            message.setMessage("Error al crear en el controller" + e);
            throw new ControllerException(e);
        }catch (Exception e){
            throw new ControllerException(e);
        }
        return ResponseEntity.ok(message);
    }

    @PostMapping("/delete")
    public ResponseEntity<Message> delete(@RequestBody DetalleFacturaDTO detalleFacturaDTO) throws ControllerException {
        Message message = new Message("0", "borrado Exitoso", null);
        try{
            detalleFacturaFacadeInterface.delete(detalleFacturaDTO);
        }catch (FacadeException e){
            message.setCodigo("1");
            message.setMessage("Error al borrar en el controller" + e);
            throw new ControllerException(e);
        }catch (Exception e){
            throw new ControllerException(e);
        }
        return ResponseEntity.ok(message);
    }

    @PostMapping("/getAll")
    public ResponseEntity<Message> getall() throws ControllerException {
        Message message = new Message("0", "getall Exitosa", null);
        try{
            List<DetalleFacturaDTO> list =  detalleFacturaFacadeInterface.getall();
            message.setData(list);
        }catch (FacadeException e){
            message.setCodigo("1");
            message.setMessage("Error al getall en el controller" + e);
            throw new ControllerException(e);
        }catch (Exception e){
            throw new ControllerException(e);
        }
        return ResponseEntity.ok(message);
    }

}
