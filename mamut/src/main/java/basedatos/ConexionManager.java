package basedatos;
import java.sql.SQLException;

public class ConexionManager {
    private static ConexionManager instance;
    private Conexion conexion;
    private ConexionManager(){
        conexion = new Conexion();
    }

    public static ConexionManager getInstance(){
        if(instance==null){
            instance = new ConexionManager();
        }

        return instance;
    }

    public void open(){
        conexion.conect();
    }

    public void close(){
        try {
            conexion.getCon().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    //atomisacion de transaccion.
    public void commit(){
        try {
            conexion.getCon().commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void rollback(){
        try {
            conexion.getCon().rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Conexion getConexion(){
        return conexion;
    }
}
