package com.softK.factura.controller;

import com.softK.factura.dto.VendedorDTO;
import com.softK.factura.exception.ControllerException;
import com.softK.factura.exception.FacadeException;
import com.softK.factura.facade.VendedorFacadeInterface;
import com.softK.factura.message.Message;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api-vendedor")
public class VendedorController {
    @Autowired
    private VendedorFacadeInterface vendedorFacadeInterface;

    @PostMapping("/save")
    @ApiOperation("Guardado del vendedor de la BD")

    public ResponseEntity<Message> save(@RequestBody VendedorDTO vendedorDTO) throws ControllerException {
        Message message = new Message("0", "Save Successful", null);
        try{
            vendedorFacadeInterface.save(vendedorDTO);
        }catch (FacadeException e){
            message.setCodigo("1");
            message.setMessage("Error al guardar " + e.getMessage());
            throw new ControllerException(e);
        }catch (Exception e){
            throw new ControllerException(e);
        }
        return ResponseEntity.ok(message);
    }

    @PostMapping("/borrar")
    @ApiOperation("Borra el vendedor de la BD por nmvendedor")
    public ResponseEntity<Message> delete(@RequestBody VendedorDTO vendedorDTO) throws ControllerException{
        Message message = new Message("0", "Save successful", null);
        try{
            vendedorFacadeInterface.delete(vendedorDTO);
        }catch (FacadeException e){
            message.setMessage("1");
            message.setMessage("Error al borrar" + e.getMessage());
            throw new ControllerException(e);
        }catch (Exception e){
            throw new ControllerException(e);
        }
        return ResponseEntity.ok(message);
    }


    @GetMapping("/getall")
    @ApiOperation("Obtener todos los vendedores")
    public ResponseEntity<Message> getall() throws ControllerException{
        Message message = new Message("0", "Save successful", null);
        try{
            List<VendedorDTO> lista = vendedorFacadeInterface.getAll();
            message.setData(lista);
        }catch (FacadeException e){
            message.setMessage("1");
            message.setMessage("Error al obtener" + e.getMessage());
            throw new ControllerException(e);
        }catch (Exception e){
            throw new ControllerException(e);
        }
        return ResponseEntity.ok(message);
    }

}
