package dto;

import java.time.LocalDate;

public class ProductoDTO {
    private int sku;
    private String dsProducto;
    public String getDsProducto() {
        return dsProducto;
    }

    public void setDsProducto(String dsProducto) {
        this.dsProducto = dsProducto;
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }


}
