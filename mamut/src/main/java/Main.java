import controller.ClienteController;
import controller.ProductoController;
import dto.ClienteDTO;
import dto.ProductoDTO;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        cliente();
    }

    public static void crear(){
        ProductoController controller = new ProductoController();
        ProductoDTO producto = new ProductoDTO();

        producto.setDsProducto("Coco");
        producto.setSku(2);

        try{
            controller.crearProducto(producto);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void all()
    {
        ProductoController controller = new ProductoController();

        try{
            List<ProductoDTO> lista = controller.getAll();
            for(int i = 0; i<lista.size(); i++){
                System.out.println(lista.get(i).getDsProducto());
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void cliente()
    {
        ClienteController controller = new ClienteController();
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setDocumento(15675189);
        clienteDTO.setDsNombres("Yhon jairo");
        clienteDTO.setDsApellidos("Diaz Gomez");
        clienteDTO.setDsDireccion("cra 29 a 28");

        try{
            controller.crearCliente(clienteDTO);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
