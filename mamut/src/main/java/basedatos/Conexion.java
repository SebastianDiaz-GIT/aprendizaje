package basedatos;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private Connection con = null;
    public Connection getCon() {
        return con;
    }

    public void conect()
    {
        try{
            String sURL = "jdbc:mysql://localhost:3306/mia";
            con = DriverManager.getConnection(sURL,"root","s0405");
            con.setAutoCommit(false);
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
