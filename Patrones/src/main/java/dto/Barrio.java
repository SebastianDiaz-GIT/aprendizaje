package dto;

public class Barrio extends Ubicacion{
    private String codBarrio;
    private String nombre;
    private Ciudad city;

    public String getCodBarrio() {
        return codBarrio;
    }

    public void setCodBarrio(String codBarrio) {
        this.codBarrio = codBarrio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ciudad getCity() {
        return city;
    }

    public void setCity(Ciudad city) {
        this.city = city;
    }
}
