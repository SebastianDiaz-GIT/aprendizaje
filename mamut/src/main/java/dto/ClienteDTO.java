package dto;

public class ClienteDTO {
    private int nmCliente;
    private int documento;
    private String dsNombres;
    private String dsApellidos;
    private String dsDireccion;

    public int getNmCliente() {
        return nmCliente;
    }

    public void setNmCliente(int nmCliente) {
        this.nmCliente = nmCliente;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getDsNombres() {
        return dsNombres;
    }

    public void setDsNombres(String dsNombres) {
        this.dsNombres = dsNombres;
    }

    public String getDsApellidos() {
        return dsApellidos;
    }

    public void setDsApellidos(String dsApellidos) {
        this.dsApellidos = dsApellidos;
    }

    public String getDsDireccion() {
        return dsDireccion;
    }

    public void setDsDireccion(String dsDireccion) {
        this.dsDireccion = dsDireccion;
    }
}
