package libreria.servicios;

import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.persistencia.AutorDao;

public class AutorServicio {

    private Scanner sc = new Scanner(System.in).useDelimiter("\n");
    private AutorDao ad = new AutorDao();

    public void guardarAutor() {

        Autor a = new Autor();

        System.out.println("Ingrese el nombre del autor");
        a.setNombre(sc.next());
        a.setAlta(true);

        ad.guardar(a);
    }

    public void editarAutor() {

        Autor a = new Autor();

        listarAutores();

        System.out.println("");

        System.out.println("Ingrese el id del autor a editar");
        a.setId(sc.nextInt());
        System.out.println("Ingrese el nuevo nombre");
        a.setNombre(sc.next());
        System.out.println("Ingrese si esta dado de alta || 1 true || 0 false");

        Boolean b;
        Integer n = sc.nextInt();

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

        a.setAlta(b);

        ad.editar(a, a.getId());

    }

    public void darAltaAutores() {

        listarAutores();

        System.out.println("");

        System.out.println("Ingrese el id del autor a editar");

        for (Autor autor : ad.buscarAutoresPorId(sc.nextInt())) {

            System.out.println("Dar de alta || 1 true || 0 false");
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

            autor.setAlta(b);

            ad.editar(autor, autor.getId());

        }

    }

    public void listarAutores() {

        System.out.println("Lista de Autores");
        for (Autor a : ad.listarAutores()) {
            System.out.println(a.toString());
        }

    }

    public void buscarAutores() {

        System.out.println("Que autor busca?");
        for (Autor a : ad.buscarAutores(sc.next())) {
            System.out.println("");
            System.out.println(a.toString());
        }

    }

    public void buscarAutoresPorId() {

        for (Autor a : ad.buscarAutoresPorId(sc.nextInt())) {

            System.out.println(a.toString());

        }
    }

}
