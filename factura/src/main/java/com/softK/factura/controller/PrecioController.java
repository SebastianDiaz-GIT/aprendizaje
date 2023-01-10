package com.softK.factura.controller;

import com.softK.factura.dto.PrecioDTO;
import com.softK.factura.exception.ControllerException;
import com.softK.factura.exception.FacadeException;
import com.softK.factura.facade.PrecioFacadeInterface;
import com.softK.factura.message.Message;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api-precio")
public class PrecioController {

    @Autowired
    private PrecioFacadeInterface precioFacadeInterface;

    @PostMapping("/crear-precio")
    @ApiOperation("Crear precios")
    public ResponseEntity<Message> crearPrecio(@RequestBody  PrecioDTO precioDTO) throws ControllerException {
        Message message = new Message("0", "Successful Create", null);
        try {
            precioFacadeInterface.save(precioDTO);
        }catch (FacadeException e){
            throw new ControllerException(e);
        }
        return ResponseEntity.ok(message);
    }


    @PostMapping("/delete-precio")
    @ApiOperation("borrar precio")
    public ResponseEntity<Message> delete(@RequestBody  PrecioDTO precioDTO) throws ControllerException {
        Message message = new Message("0", "Successful delete", null);
        try {
            precioFacadeInterface.delete(precioDTO);
        }catch (FacadeException e){
            throw new ControllerException(e);
        }
        return ResponseEntity.ok(message);
    }

    @GetMapping("/getall-precio")
    @ApiOperation("Obtener todos los precios")
    public ResponseEntity<Message> getall() throws ControllerException {
        Message message = new Message("0", "Successful get all found", null);
        try {
            List<PrecioDTO> list = precioFacadeInterface.getPrecios();
            message.setData(list);
        }catch (FacadeException e){
            message.setMessage("Error en el controlador");
            message.setCodigo("1");
            throw new ControllerException(e);
        }
        return ResponseEntity.ok(message);
    }
}
