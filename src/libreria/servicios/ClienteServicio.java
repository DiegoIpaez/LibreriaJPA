package libreria.servicios;

import java.util.Scanner;
import libreria.entidades.Cliente;
import libreria.persistencia.ClienteDao;

public class ClienteServicio {

    private ClienteDao cd = new ClienteDao();
    private Scanner sc = new Scanner(System.in).useDelimiter("\n");
    
    public void guardarCliente(){
    
        Cliente c = new Cliente();
        
        System.out.println("Ingrese el nombre del cliente");
        c.setNombre(sc.next());
        System.out.println("Ingrese el apellido");
        c.setApellido(sc.next());
        System.out.println("Ingrese el telefono");
        c.setTelefono(sc.next());
        System.out.println("Ingrese el documento");
        c.setDocumento(sc.nextLong());
        
        cd.guardar(c);
    }
    
    public void listarClientes(){
    
        System.out.println("Lista de Clientes");
        for (Cliente c : cd.listarClientes()) {
            
            System.out.println(c.toString());
            
        }
        
    }
    
}
