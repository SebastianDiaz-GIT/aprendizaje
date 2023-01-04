package dto;

import java.util.List;

public class Colegio {
    private String nombre;
    private String codigo;
    private List<Aulas> aula;

    public List<Aulas> getAula() {
        return aula;
    }

    public void setAula(List<Aulas> aula) {
        this.aula = aula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Colegio{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", aula=" + aula +
                '}';
    }
}
