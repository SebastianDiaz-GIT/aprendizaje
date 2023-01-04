package funcionales;

public class Calculadora {

    private int a;
    private int b;

    public Calculadora() {

    }

    public Calculadora(int a, int b)
    {
        this.a = a;
        this.b = b;
    }

    public int sumar()
    {
        return a+b;
    }
}
