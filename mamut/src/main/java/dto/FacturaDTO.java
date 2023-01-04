package dto;

import java.time.LocalDate;
public class FacturaDTO {


    //Parametros
    private int nmFactura;
    private char cdFactura;
    private VendedorDTO nmVendedor ;
    private ClienteDTO nmCliente ;
    private LocalDate feFactura;

    public int getNmFactura() {
        return nmFactura;
    }

    public void setNmFactura(int nmFactura) {
        this.nmFactura = nmFactura;
    }

    public char getCdFactura() {
        return cdFactura;
    }

    public void setCdFactura(char cdFactura) {
        this.cdFactura = cdFactura;
    }

    public VendedorDTO getNmVendedor() {
        return nmVendedor;
    }

    public void setNmVendedor(VendedorDTO nmVendedor) {
        this.nmVendedor = nmVendedor;
    }

    public ClienteDTO getNmCliente() {
        return nmCliente;
    }

    public void setNmCliente(ClienteDTO nmCliente) {
        this.nmCliente = nmCliente;
    }

    public LocalDate getFeFactura() {
        return feFactura;
    }

    public void setFeFactura(LocalDate feFactura) {
        this.feFactura = feFactura;
    }
}
