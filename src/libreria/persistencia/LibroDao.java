package libreria.persistencia;

import java.util.List;
import javax.persistence.Query;
import libreria.entidades.Libro;

public class LibroDao extends Dao<Libro, Long> {

    public List<Libro> listarLibros() {

        conectar();

        List<Libro> libros = null;

        try {

            String queryJSQL = "select l from Libro l";

            Query query = em.createQuery(queryJSQL);

            libros = query.getResultList();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            desconectar();

        }

        return libros;
    }
    
    public List<Libro> BuscarLibros(String nombre) {

        conectar();

        List<Libro> libros = null;

        try {

            String queryJSQL = "select l from Libro l where l.titulo like :title";

            Query query = em.createQuery(queryJSQL).setParameter("title", "%"+nombre+"%");

            libros = query.getResultList();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            desconectar();

        }

        return libros;
    }

    public List<Libro> BuscarLibroPorId(Integer uid) {

        conectar();

        List<Libro> libros = null;

        try {

            String queryJSQL = "select l from Libro l where l.isbn = :uid";

            Query query = em.createQuery(queryJSQL).setParameter("uid", uid);

            libros = query.getResultList();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            desconectar();

        }

        return libros;
    }
    
    public List<Libro> BuscarLibroPorAutor(String nombre) {

        conectar();

        List<Libro> libros = null;

        try {

            String queryJSQL = "select l from Libro l where l.autor.nombre like :title";

            Query query = em.createQuery(queryJSQL).setParameter("title", "%"+nombre+"%");

            libros = query.getResultList();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            desconectar();

        }

        return libros;
    }
    
    public List<Libro> BuscarLibroPorEditorial(String nombre) {

        conectar();

        List<Libro> libros = null;

        try {

            String queryJSQL = "select l from Libro l where l.editorial.nombre like :title";

            Query query = em.createQuery(queryJSQL).setParameter("title", "%"+nombre+"%");

            libros = query.getResultList();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            desconectar();

        }

        return libros;
    }
    
    
    public void editarLibro(Libro objeto, Long id) {
        conectar();

        try {

            em.getTransaction().begin();

            em.find(objeto.getClass(), id);

            em.merge(objeto);

            em.getTransaction().commit();

        } catch (Exception e) {

            e.printStackTrace();
            em.getTransaction().rollback();
            System.out.println("Ocurrio un error al editar el objeto de tipo: " + objeto.getClass().getSimpleName());

        } finally {
            desconectar();
        }

    }
}
