package libreria.servicios;

import java.util.Date;
import java.util.Scanner;
import libreria.entidades.Cliente;
import libreria.entidades.Libro;
import libreria.entidades.Prestamo;
import libreria.persistencia.ClienteDao;
import libreria.persistencia.LibroDao;
import libreria.persistencia.PrestamoDao;

public class PrestamoServicio {

    private Scanner sc = new Scanner(System.in).useDelimiter("\n");
    private PrestamoDao pd = new PrestamoDao();

    public void guardarPrestamo() {
        
        
        Prestamo p = new Prestamo();
        
        Date f = new Date();
        Date fd = new Date();
        
        LibroDao ld = new LibroDao();
        ClienteDao cd = new ClienteDao();
        
        p.setFechaPrestamo(f);
        
        //Seteo la fecha para que se un mes mas
        fd.setMonth(f.getMonth()+1);
        
        System.out.println("Ingrese el dia de la devolucion");
        p.setFechaDevolucion(fd);
        
        System.out.println("Ingresa el id del Libro");
        for (Libro libro : ld.BuscarLibroPorId(sc.nextInt())) {
            p.setLibro(libro);
        }
        
        System.out.println("Ingresa el id del cliente");
        for (Cliente c : cd.BuscarClientePorId(sc.nextInt())) {
            p.setCliente(c);
        }
        
        pd.guardar(p);
        
    }
    
    public void listarPrestamos(){
    
        System.out.println("Lista de Prestamos");
        for (Prestamo prestamo : pd.listarPrestamos()) {
            System.out.println(prestamo.toString());
        }
    }
    
    public void buscarPrestamosPorCliente(){
    
        System.out.println("Ingrese el nombre del cliente para ver sus Prestamos");
        for (Prestamo p : pd.buscarPrestamosPorCliente(sc.next())) {
            System.out.println(p.toString());
        }
    }

}
