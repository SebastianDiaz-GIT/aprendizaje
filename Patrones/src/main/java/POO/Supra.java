package POO;

public class Supra extends Auto {

    //metodos y atributos propios de la clase mustang
    private static String modelo = " GR 86";

    public void honk(){
        System.out.println("Pii Piiiii Piiip!!!");
    }

    public static void main(String[] args) {
        Supra supra = new Supra();
        supra.setColor("Blanco");
        supra.setPrecio(150000000);
        supra.promocionar();
        System.out.println("el modelo del auto es: " + modelo);
        supra.honk();
    }
}
