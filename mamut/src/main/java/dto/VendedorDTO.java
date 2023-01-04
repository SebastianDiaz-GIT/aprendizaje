package dto;

public class VendedorDTO {
    private int nmVendedor;
    private char documento;
    private char dsNombre;
    private char apellidos;
    private char dsDireccion;

    public int getNmVendedor() {
        return nmVendedor;
    }

    public void setNmVendedor(int nmVendedor) {
        this.nmVendedor = nmVendedor;
    }

    public char getDocumento() {
        return documento;
    }

    public void setDocumento(char documento) {
        this.documento = documento;
    }

    public char getDsNombre() {
        return dsNombre;
    }

    public void setDsNombre(char dsNombre) {
        this.dsNombre = dsNombre;
    }

    public char getApellidos() {
        return apellidos;
    }

    public void setApellidos(char apellidos) {
        this.apellidos = apellidos;
    }

    public char getDsDireccion() {
        return dsDireccion;
    }

    public void setDsDireccion(char dsDireccion) {
        this.dsDireccion = dsDireccion;
    }
}
