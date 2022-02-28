package libreria.servicios;

import java.util.Scanner;
import libreria.entidades.Editorial;
import libreria.persistencia.EditorialDao;

public class EditorialServicio {

    private Scanner sc = new Scanner(System.in).useDelimiter("\n");
    private EditorialDao ed = new EditorialDao();

    public void guardarEditorial() {

        Editorial e = new Editorial();

        System.out.println("Ingrese el nombre de la Editorial");
        e.setNombre(sc.next());
        e.setAlta(true);

        ed.guardar(e);
    }

    public void darAltaEditorial() {
        
        System.out.println("");
        listarEditoriales();

        System.out.println("Ingrese el id de la editorial a dar de alta");
        for (Editorial e : ed.buscarEditorialesPorId(sc.nextInt())) {

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

            e.setAlta(b);
            
            ed.editar(e, e.getId());

        }

    }

    public void listarEditoriales() {

        System.out.println("Lista de Editoriales");
        for (Editorial e : ed.listarEditoriales()) {
            System.out.println(e.toString());
        }
    }

    public void buscarEditorialesPorId() {

        System.out.println("Ingrese el id de la editorial");
        for (Editorial editorial : ed.buscarEditorialesPorId(sc.nextInt())) {
            System.out.println(editorial.toString());
        }
    }

}
