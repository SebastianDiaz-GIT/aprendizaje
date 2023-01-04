import abstractas.AutoBMW;
import abstractas.AutoBrazil;
import dto.Aulas;
import dto.Barrio;
import dto.Ciudad;
import dto.Colegio;
import funcionales.Calculadora;
import interfaz.InterfazDado;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //llenarAulas();
        //llenarCiudades();
        //calculadora();
        //AbstractClass();
        interfaz();
    }

    public static void llenarAulas()
    {
        Colegio colegio = new Colegio();
        Aulas aula1 = new Aulas();
        aula1.setCodigo("01");
        aula1.setAlumnos(10);
        Aulas aula2 = new Aulas();
        aula2.setCodigo("02");
        aula2.setAlumnos(20);

        List<Aulas> aulas = new ArrayList<>();
        aulas.add(aula1);
        aulas.add(aula2);

        colegio.setNombre("Restrepo");
        colegio.setCodigo("00001");
        colegio.setAula(aulas);

        System.out.println(colegio.getAula().toString());


    }

    public static void llenarCiudades()
    {
        Ciudad ciudad = new Ciudad();
        ciudad.setName("medellin");
        ciudad.setCode("01");

        ciudad.setLatitud(12701201);
        ciudad.setLongitud(123123123);

        Barrio barrio = new Barrio();
        barrio.setCodBarrio("201");
        barrio.setNombre("manrique");
        barrio.setCity(ciudad);

        System.out.println(barrio.getCity().toString());
    }

    public static void calculadora()
    {
        Calculadora calculadora = new Calculadora(10, 15);
        System.out.println(calculadora.sumar());
    }

    public static void interfaz()
    {
        InterfazDado dado = null;
        try {
            dado = (InterfazDado)Class.forName("interfaz.DadoOriental").newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        dado.lanzar();
    }

    public static void AbstractClass()
    {
        AutoBMW Auto = new AutoBrazil();
        Auto.chazis();
        Auto.diseño();
        Auto.motor();
    }
}
