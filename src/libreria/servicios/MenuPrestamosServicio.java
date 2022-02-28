/*
c) Tareas a Realizar
Al alumno le toca desarrollar, las siguientes funcionalidades:
1. Creación de un Cliente nuevo
2. Crear entidad Préstamo
3. Registrar el préstamo de un libro.
4. Devolución de un libro
5. Búsqueda de todos los prestamos de un Cliente.
6. Agregar validaciones a todas las funcionalidades de la aplicación:
• Validar campos obligatorios.
• No ingresar datos duplicados.
• No generar condiciones inválidas. Por ejemplo, no se debe permitir prestar más
ejemplares de los que hay, ni devolver más de los que se encuentran prestados.
No se podrán prestar libros con fecha anterior a la fecha actual, etc.
 */
package libreria.servicios;

import java.util.Scanner;

public class MenuPrestamosServicio {

    private Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public void menu() {
        
        ClienteServicio c = new ClienteServicio();
        PrestamoServicio p = new PrestamoServicio();

        String op;
        Boolean salir = false;

        while (!salir) {

            System.out.println("");
            System.out.println("Que deseas hacer?");
            System.out.println("a) Ingresar Cliente nuevo");
            System.out.println("b) Iniciar Prestamo");
            System.out.println("c) Devolucion de libro");
            System.out.println("d) Buscar todos los prestamos de un cliente");
            System.out.println("--------------------------------------------");
            System.out.println("s) Para salir");

            op = sc.nextLine();

            switch (op) {
                case "a":
                    System.out.println("Ingrese el cliente nuevo");
                    c.guardarCliente();
                    System.out.println("");
                    c.listarClientes();
                    break;
                case "b":
                    System.out.println("");

                    break;
                case "c":
                    System.out.println("");

                    break;
                case "d":
                    System.out.println("");

                    break;

                case "s":
                    salir = true;
                    break;
            }//fin switch
        }//Fin while
    }
}
