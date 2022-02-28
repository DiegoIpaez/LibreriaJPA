package libreria.servicios;

import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.persistencia.AutorDao;
import libreria.persistencia.EditorialDao;
import libreria.persistencia.LibroDao;

public class LibroServicio {

    private final Scanner sc = new Scanner(System.in).useDelimiter("\n");
    private final LibroDao ld = new LibroDao();
    private final AutorDao as = new AutorDao();
    private final EditorialDao ed = new EditorialDao();
    
    
    public void guardarLibro() {

        //Instancio mi objeto Libro
        Libro l = new Libro();
        

        //Le pido al usuario el titulo
        System.out.println("Ingrese el titulo del libro");
        l.setTitulo(sc.next());

        //Le pido al usuario el num. de ejmplares
        System.out.println("Ingrese el numero de ejemplares");
        l.setEjemplares(sc.nextInt());

        l.setEjemplaresPrestados(0);
        l.setEjemplaresRestantes(l.getEjemplares() - l.getEjemplaresPrestados());

        //Le pido al usuario el año de salida
        System.out.println("Ingrese el año");
        l.setAnio(sc.nextInt());

        //Estado
        l.setAlta(true);

        //Uso la validacion del id autor
        System.out.println("Ingrese el id del autor correspondiente");
        for (Autor a : as.buscarAutoresPorId(sc.nextInt())) {

            //Seteo la propiedad autor
            l.setAutor(a);
        }

        //Uso la validacion del id Editorial
        System.out.println("Ingrese el id de la editorial correspondiente");
        for (Editorial editorial : ed.buscarEditorialesPorId(sc.nextInt())) {
            //Seteo la editorial
            l.setEditorial(editorial);
        }

        //Guardo
        ld.guardar(l);
    }

    public void darAltaLibro() {

        listarLibros();

        System.out.println("Ingrese el id del libro a dar de alta");
        for (Libro l : ld.BuscarLibroPorId(sc.nextInt())) {

            System.out.println("Ingrese si esta dado de alta || 1 true || 0 false");

            Integer n = sc.nextInt();

            Boolean b;

            switch (n) {
                case 1:
                    b = true;
                    break;
                case 0:
                    b = false;
                    break;
                default:
                    b = true;
                    break;
            }
            
            l.setAlta(b);

            ld.editar(l, l.getIsbn());
        }
    }

    public void listarLibros() {

        System.out.println("Lista de Libros");
        for (Libro l : ld.listarLibros()) {
            System.out.println(l.toString());
        }
    }

    public void buscarLibros() {

        System.out.println("Ingrese el titulo del libro");
        for (Libro l : ld.BuscarLibros(sc.next())) {
            System.out.println(l.toString());
        }
    }

    public void buscarLibroPorId() {

        System.out.println("Ingrese el libro por su ISBN");
        for (Libro libro : ld.BuscarLibroPorId(sc.nextInt())) {
            System.out.println(libro.toString());
        }
    }

    public void buscarLibroPorAutor() {

        System.out.println("Ingrese el Autor del libro");
        for (Libro l : ld.BuscarLibroPorAutor(sc.next())) {
            System.out.println(l.toString());
        }
    }

    public void buscarLibroPorEditorial() {

        System.out.println("Ingrese la editorial del libro");
        for (Libro l : ld.BuscarLibroPorEditorial(sc.next())) {
            System.out.println(l.toString());
        }
    }

}
