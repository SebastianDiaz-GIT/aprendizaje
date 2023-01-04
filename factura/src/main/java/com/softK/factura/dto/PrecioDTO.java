package com.softK.factura.dto;


import org.springframework.jdbc.core.RowCallbackHandler;

public class PrecioDTO {
    private int nmprecio;
    private double precio;
    private java.sql.Date fedesde;
    private java.sql.Date fehasta;
    private ProductoDTO productoDTO;


    public int getNmprecio() {
        return nmprecio;
    }

    public void setNmprecio(int nmprecio) {
        this.nmprecio = nmprecio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public java.sql.Date getFedesde() {
        return fedesde;
    }

    public void setFedesde(java.sql.Date fedesde) {
        this.fedesde = fedesde;
    }

    public java.sql.Date getFehasta() {
        return fehasta;
    }

    public void setFehasta(java.sql.Date fehasta) {
        this.fehasta = fehasta;
    }

    public ProductoDTO getProductoDTO() {
        return productoDTO;
    }

    public void setProductoDTO(ProductoDTO productoDTO) {
        this.productoDTO = productoDTO;
    }

}
