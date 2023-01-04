package POO;

public class Auto {
    private String color;
    protected String marca = "TOYOTA";
    private int precio;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void promocionar(){
        System.out.println("SE VENDEEE!!! " + marca + " A " + precio + "PESOOOOOS");
    }
}
