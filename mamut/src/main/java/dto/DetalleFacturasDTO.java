package dto;

public class DetalleFacturasDTO extends FacturaDTO{
    private int nmdetfactura = this.getNmFactura();
    private char sku;
    private int cantidad;
    private int nmprecio;
    private double precio;

    public int getNmdetfactura() {
        return nmdetfactura;
    }

    public void setNmdetfactura(int nmdetfactura) {
        this.nmdetfactura = nmdetfactura;
    }

    public char getSku() {
        return sku;
    }

    public void setSku(char sku) {
        this.sku = sku;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

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
}
