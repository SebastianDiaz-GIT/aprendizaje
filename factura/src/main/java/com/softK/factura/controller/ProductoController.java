package com.softK.factura.controller;

import com.softK.factura.dto.ProductoDTO;
import com.softK.factura.exception.ControllerException;
import com.softK.factura.exception.FacadeException;
import com.softK.factura.facade.ProductFacadeInterface;
import com.softK.factura.facade.ProductoFacade;
import com.softK.factura.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api")
public class ProductoController {

    @Autowired
    private ProductFacadeInterface productoFacade;
    /*
    public ProductoController()
    {
        productoFacade = new ProductoFacade();
    }
     */

    @PostMapping("/producto/crearProducto")
    public ResponseEntity<Message> crearProducto(@RequestBody ProductoDTO producto) throws ControllerException
    {

        Message message = new Message("0","Creacion exitosa",null);
        try{
            productoFacade.crearProducto(producto);

        }catch (FacadeException ex){
            message.setCodigo("1");
            message.setMessage("Error en crear producto"+ex.getMessage());
            throw new ControllerException(ex);
        }catch (Exception e)
        {
            message.setCodigo("1");
            message.setMessage(e.getMessage());
            throw new ControllerException(e);
        }

        return ResponseEntity.ok( message );
    }
    @PostMapping("/producto/borrarProducto")
    public ResponseEntity<Message> borrarProducto(@RequestBody ProductoDTO producto)
    {
        Message message = new Message("0","Delete exitosa",null);
        try{
            productoFacade.borrarProducto(producto);
        }catch (FacadeException ex){
            message.setCodigo("1");
            message.setMessage("Error en borrar producto"+ex.getMessage());

        }catch (Exception e)
        {
            message.setCodigo("1");
            message.setMessage("Error en borrar producto"+e.getMessage());

        }
        return ResponseEntity.ok( message );
    }
    @GetMapping("/producto/getAll")
    public ResponseEntity<Message> getAll() throws ControllerException{

        Message message = new Message("0","GetAll exitosa",null);
        try{
            List<ProductoDTO> lista = productoFacade.getAll();
            message.setData(lista);
        }catch (FacadeException ex){
            message.setCodigo("1");
            message.setMessage("Error en getAll producto"+ex.getMessage());
            throw new ControllerException(ex);
        }catch (Exception e)
        {
            message.setCodigo("1");
            message.setMessage("Error en getAll producto"+e.getMessage());
            throw new ControllerException(e);
        }
        return ResponseEntity.ok( message );
    }

    @PostMapping("/getbyname")
    public ResponseEntity<Message> getbyname(@RequestBody ProductoDTO productoDTO) throws ControllerException{
        Message message = new Message("0","producto exitoso",null);

        try{
            List<ProductoDTO> producto = productoFacade.getbyname(productoDTO);
            message.setData(producto);
        }catch (FacadeException ex){
            message.setCodigo("1");
            message.setMessage("Error en getAll producto"+ex.getMessage());
            throw new ControllerException(ex);
        }catch (Exception e)
        {
            message.setCodigo("1");
            message.setMessage("Error en getAll producto"+e.getMessage());
            throw new ControllerException(e);
        }
        return ResponseEntity.ok( message );
    }
}
