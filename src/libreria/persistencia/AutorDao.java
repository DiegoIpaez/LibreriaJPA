package libreria.persistencia;

import java.util.List;
import javax.persistence.Query;
import libreria.entidades.Autor;

public class AutorDao extends Dao<Autor, Integer> {

    public List<Autor> listarAutores() {

        conectar();

        List<Autor> autores = null;

        try {
            String queryJSQL = "select a from Autor a";

            Query query = em.createQuery(queryJSQL);

            autores = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            desconectar();
        }

        return autores;
    }

    public List<Autor> buscarAutores(String nombre) {

        conectar();

        List<Autor> autores = null;

        try {
            String queryJSQL = "select a from Autor a where a.nombre like :pepe";

            Query query = em.createQuery(queryJSQL).setParameter("pepe", "%" + nombre + "%");

            autores = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            desconectar();
        }

        return autores;
    }

    public List<Autor> buscarAutoresPorId(Integer id) {

        conectar();

        List<Autor> autores = null;

        try {
            String queryJSQL = "select a from Autor a where a.id = :pepe";

            Query query = em.createQuery(queryJSQL).setParameter("pepe", id);

            autores = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            desconectar();
        }

        return autores;
    }

}
