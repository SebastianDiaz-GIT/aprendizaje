package dao;

import basedatos.Conexion;
import basedatos.ConexionManager;
import dto.ClienteDTO;
import exception.DaoExceptions;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO implements ClienteDaoInterfaz{

    Conexion con = ConexionManager.getInstance().getConexion();
    public void insert(ClienteDTO clienteDTO) throws DaoExceptions
    {
        Connection connection = con.getCon();
        PreparedStatement preparedStatement = null;
        String insertar = "INSERT INTO mia.cliente\n" +
                "(documento, dsnombre, dsapellido, dsdireccion)\n" +
                "VALUES(?, ?, ?, ?);\n";

        try{
            preparedStatement = connection.prepareStatement(insertar);
            preparedStatement.setInt(1,clienteDTO.getDocumento());
            preparedStatement.setString(2,clienteDTO.getDsNombres());
            preparedStatement.setString(3, clienteDTO.getDsApellidos());
            preparedStatement.setString(4,clienteDTO.getDsDireccion());
            preparedStatement.executeUpdate();

        }catch (SQLException ex){
            throw new DaoExceptions(ex);
        }catch (Exception ex)
        {
            throw new DaoExceptions(ex);
        }finally {
            try{
                preparedStatement.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }

    public void delete(ClienteDTO clienteDTO) throws DaoExceptions
    {

    }

    public void update(ClienteDTO clienteDTO) throws DaoExceptions{
        Connection connection = con.getCon();
        PreparedStatement preparedStatement = null;
        String update = "UPDATE mia.cliente\n" +
                "SET dsnombre=?, dsapellido=?, dsdireccion=?\n" +
                "WHERE documento =?";

        try{
            preparedStatement = connection.prepareStatement(update);
            preparedStatement.setInt(4,clienteDTO.getDocumento());
            preparedStatement.setString(1,clienteDTO.getDsNombres());
            preparedStatement.setString(2, clienteDTO.getDsApellidos());
            preparedStatement.setString(3,clienteDTO.getDsDireccion());
            preparedStatement.executeUpdate();

        }catch (SQLException ex){
            throw new DaoExceptions(ex);
        }catch (Exception ex)
        {
            throw new DaoExceptions(ex);
        }finally {
            try{
                preparedStatement.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void getall() throws DaoExceptions
    {

    }

    public int getById(ClienteDTO clienteDTO) throws DaoExceptions
    {
        Connection connection = con.getCon();
        PreparedStatement preparedStatement = null;
        String getByDoc = "select count(*) as cantidad from cliente  where documento=?";
        int cantidad = 0;
        ResultSet rs = null;

        try{
            preparedStatement = connection.prepareStatement(getByDoc);
            preparedStatement.setInt(1,clienteDTO.getDocumento());
            rs = preparedStatement.executeQuery();

            if(rs!=null)
            {
                while(rs.next()){
                    // Result set
                    cantidad = rs.getInt("cantidad");
                }
            }

        }catch (SQLException ex)
        {
            throw new DaoExceptions(ex);
        }catch (Exception e)
        {
            throw new DaoExceptions(e);
        }finally
        {
            try{
                //cierro la conexion con la base de datos  para o dejarlas huerfanas
                rs.close();
                preparedStatement.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return cantidad;
    }
}
