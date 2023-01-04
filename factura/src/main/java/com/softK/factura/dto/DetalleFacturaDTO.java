package com.softK.factura.dto;

public class DetalleFacturaDTO {
    private int nmdetfactura;
    private int cantidad;
    private double precio;
    private ProductoDTO sku;
    private FacturaDTO nmfactura;
    private PrecioDTO nmprecio;

    public int getNmdetfactura() {
        return nmdetfactura;
    }

    public void setNmdetfactura(int nmdetfactura) {
        this.nmdetfactura = nmdetfactura;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ProductoDTO getSku() {
        return sku;
    }

    public void setSku(ProductoDTO sku) {
        this.sku = sku;
    }

    public FacturaDTO getNmfactura() {
        return nmfactura;
    }

    public void setNmfactura(FacturaDTO nmfactura) {
        this.nmfactura = nmfactura;
    }

    public PrecioDTO getNmprecio() {
        return nmprecio;
    }

    public void setNmprecio(PrecioDTO nmprecio) {
        this.nmprecio = nmprecio;
    }
}
