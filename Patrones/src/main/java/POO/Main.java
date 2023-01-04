package POO;

public class Main {
    public Main()
    {
        // EN CASO DE QUE EL OBJETO NO SE INICIALICE CON ATRIBUTOS
    }

    public Main(int x){
        // INDICO EL PRIMER ATRIBUTO QUE SE LE ASIGNE AL OBJETO
        System.out.println(x + 1);
    }

    public Main(int x, int y){
        System.out.println("x = " + x + ", y = " + y);
    }

    public static void main(String[] args) {
        Main main = new Main(1,2);
        Main main1 = new Main(5);
    }
}
