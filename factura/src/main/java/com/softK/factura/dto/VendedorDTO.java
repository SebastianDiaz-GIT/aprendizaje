package com.softK.factura.dto;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.lang.NonNull;

public class VendedorDTO {
    private int nmvendedor;
    private String documentov;
    private String dsvnombre;
    private String dsvapellido;
    private String dsvdireccion;

    public int getNmvendedor() {
        return nmvendedor;
    }

    public void setNmvendedor(int nmvendedor) {
        this.nmvendedor = nmvendedor;
    }

    public String getDocumentov() {
        return documentov;
    }

    public void setDocumentov(String documentov) {
        this.documentov = documentov;
    }

    public String getDsvnombre() {
        return dsvnombre;
    }

    public void setDsvnombre(String dsvnombre) {
        this.dsvnombre = dsvnombre;
    }

    public String getDsvapellido() {
        return dsvapellido;
    }

    public void setDsvapellido(String dsvapellido) {
        this.dsvapellido = dsvapellido;
    }

    public String getDsvdireccion() {
        return dsvdireccion;
    }

    public void setDsvdireccion(String dsvdireccion) {
        this.dsvdireccion = dsvdireccion;
    }
}
