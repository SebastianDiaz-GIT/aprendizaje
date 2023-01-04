package com.softK.factura.dto;


import java.sql.Date;

public class FacturaDTO {

    private int nmfactura;
    private String cdfactura;
    private VendedorDTO nmvendedor;
    private ClienteDTO nmcliente;
    private Date fefactura;

    public int getNmfactura() {
        return nmfactura;
    }

    public void setNmfactura(int nmfactura) {
        this.nmfactura = nmfactura;
    }

    public String getCdfactura() {
        return cdfactura;
    }

    public void setCdfactura(String cdfactura) {
        this.cdfactura = cdfactura;
    }

    public VendedorDTO getNmvendedor() {
        return nmvendedor;
    }

    public void setNmvendedor(VendedorDTO nmvendedor) {
        this.nmvendedor = nmvendedor;
    }

    public ClienteDTO getNmcliente() {
        return nmcliente;
    }

    public void setNmcliente(ClienteDTO nmcliente) {
        this.nmcliente = nmcliente;
    }

    public Date getFefactura() {
        return fefactura;
    }

    public void setFefactura(Date fefactura) {
        this.fefactura = fefactura;
    }
}
