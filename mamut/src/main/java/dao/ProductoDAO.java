package dao;

import basedatos.Conexion;
import basedatos.ConexionManager;
import dto.ProductoDTO;
import exception.DaoExceptions;
import exception.ManagerException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO implements ProducDaoInterface {

    Conexion con = ConexionManager.getInstance().getConexion();

    public void insert(ProductoDTO producto) throws DaoExceptions {
        Connection connection = con.getCon();
        PreparedStatement preparedStatement = null;
        String insertar = "INSERT INTO producto\n" +
                "(sku,\n" +
                "dsproducto)\n" +
                "VALUES\n" +
                "(?,?)";
        try{
            preparedStatement = connection.prepareStatement(insertar);
            preparedStatement.setInt(1,producto.getSku());
            preparedStatement.setString(2,producto.getDsProducto());
            preparedStatement.executeUpdate();
        }catch (SQLException ex)
        {
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

    public void delete(ProductoDTO producto)  throws DaoExceptions
    {
        Connection connection = con.getCon();
        PreparedStatement preparedStatement = null;
        String borrar = "DELETE FROM producto\n" +
                "WHERE sku=?;\n";

        try{
            preparedStatement = connection.prepareStatement(borrar);
            preparedStatement.setInt(1, producto.getSku());
            preparedStatement.executeUpdate();
            System.out.println("Borrando : " + producto.getSku());

        }catch (SQLException ex)
        {
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

    public void update(ProductoDTO producto) throws DaoExceptions {
        Connection connection = con.getCon();
        PreparedStatement preparedStatement = null;
        String insertar = "UPDATE producto\n" +
                "SET dsproducto=?\n" +
                "WHERE sku=?;\n";
        try{
            preparedStatement = connection.prepareStatement(insertar);
            preparedStatement.setString(1, producto.getDsProducto());
            preparedStatement.setInt(2, producto.getSku());
            preparedStatement.executeUpdate();
        }catch (SQLException ex)
        {
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

    public int count(ProductoDTO producto) throws DaoExceptions
    {
        Connection connection = con.getCon();
        PreparedStatement preparedStatement = null;
        String SELECT = "select count(*) as cantidad from producto where sku=?";
        ResultSet rs = null;
        int cantidad=0;
        try{
            preparedStatement = connection.prepareStatement(SELECT);

            preparedStatement.setInt(1, producto.getSku());
            rs=preparedStatement.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    cantidad = rs.getInt("cantidad");
                }
            }

        }catch (SQLException ex)
        {
            throw new DaoExceptions(ex);
        }catch (Exception ex)
        {
            throw new DaoExceptions(ex);
        }finally {
            try{
                rs.close();
                preparedStatement.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return cantidad;
    }

    public List getAll() throws DaoExceptions{
        Connection connection = con.getCon();
        PreparedStatement preparedStatement = null;
        String SELECT = "SELECT sku, dsproducto FROM producto ORDER BY sku";
        ResultSet rs = null;
        List productoLista = new ArrayList<ProductoDTO>();

        try{
            preparedStatement = connection.prepareStatement(SELECT);
            rs=preparedStatement.executeQuery();
            ProductoDTO producto = null;

            if (rs!=null)
            {
                while(rs.next())
                {
                    producto = new ProductoDTO();
                    producto.setDsProducto(rs.getString("dsproducto"));
                    producto.setSku(rs.getInt("sku"));
                    productoLista.add(producto);
                }
            }
        }catch (SQLException ex){
            throw new DaoExceptions();
        }catch (Exception e)
        {
            throw new DaoExceptions();
        }finally {
            try{
                rs.close();
                preparedStatement.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return productoLista;
    }

}
