/*
e) Tareas a Realizar
Al alumno le toca desarrollar, las siguientes funcionalidades:
1) Crear base de datos Librería
2) Crear unidad de persistencia
3) Crear entidades previamente mencionadas ( excepto Préstamo )
4) Generar las tablas con JPA
5) Crear servicios previamente mencionados.
6) Crear los métodos para persistir entidades en la base de datos librería
7) Crear los métodos para dar de alta/bajo o editar dichas entidades.
8) Búsqueda de un Autor por nombre.
9) Búsqueda de un libro por ISBN.
10) Búsqueda de un libro por Título.
11) Búsqueda de un libro/s por nombre de Autor.
12) Búsqueda de un libro/s por nombre de Editorial.
13) Agregar las siguientes validaciones a todas las funcionalidades de la aplicación:
• Validar campos obligatorios.
• No ingresar datos duplicados.
 */
package libreria.servicios;

import java.util.Scanner;

public class MenuServicio {

    private final Scanner sc = new Scanner(System.in).useDelimiter("\n");
    private final LibroServicio l = new LibroServicio();
    private final AutorServicio a = new AutorServicio();
    private final EditorialServicio e = new EditorialServicio();

    public void menu() {
        String op;
        Boolean salir = false;

        while (!salir) {

            System.out.println("");
            System.out.println("Que deseas hacer?");
            System.out.println("a) Dar de alta Autor");
            System.out.println("b) Dar de alta Editorial");
            System.out.println("c) Dar de alta Libro");
            System.out.println("d) Ingresar Libro");
            System.out.println("e) Busqueda de autor por nombre");
            System.out.println("f) Busqueda de libro por ISBN");
            System.out.println("g) Busqueda de libro por Autor");
            System.out.println("h) Busqueda de libro por Editorial");
            System.out.println("--------------------------------------------");
            System.out.println("s) Para salir");

            op = sc.nextLine();

            switch (op) {
                case "a":
                    System.out.println("Dar de alta Autor");
                    a.darAltaAutores();
                    break;
                case "b":
                    System.out.println("");
                    e.darAltaEditorial();
                    break;
                case "c":
                    System.out.println("");
                    l.darAltaLibro();
                    break;
                case "d":
                    System.out.println("");
                    a.listarAutores();
                    System.out.println("");
                    e.listarEditoriales();
                    System.out.println("");
                    l.guardarLibro();
                    break;
                case "e":
                    System.out.println("");
                    a.buscarAutores();
                    break;
                case "f":
                    System.out.println("");
                    l.buscarLibroPorId();
                    break;
                case "g":
                    System.out.println("");
                    l.buscarLibroPorAutor();
                    break;
                case "h":
                    System.out.println("");
                    l.buscarLibroPorEditorial();
                    break;

                case "s":
                    salir = true;
                    break;
            }//fin switch
        }//Fin while
    }

}
