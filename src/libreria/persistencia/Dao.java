package libreria.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public class Dao<T extends Object, I extends Object> {

    protected EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();

    protected void conectar() {

        if (!em.isOpen()) {
            em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        }

    }

    protected void desconectar() {

        if (em.isOpen()) {
            em.close();
        }

    }

    public void guardar(T objeto) {
        conectar();

        try {

            //Inicia la transaccion/Consulta
            em.getTransaction().begin();

            //Se ejecuta la query
            em.persist(objeto);

            //Confirma la transaccion/Consulta
            em.getTransaction().commit();

        } catch (Exception e) {

            e.printStackTrace();
            em.getTransaction().rollback();
            System.out.println("Ocurrio un error al persistir el objeto de tipo: " + objeto.getClass().getSimpleName());

        } finally {
            desconectar();
        }

    }

    public void editar(T objeto, I id) {
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

    public void eliminar(Class<T> clase, I id) {
        conectar();

        try {

            em.getTransaction().begin();

            T objeto = (T) em.find(clase, id);

            em.remove(objeto);

            em.getTransaction().commit();

        } catch (Exception e) {

            e.printStackTrace();
            em.getTransaction().rollback();
            System.out.println("Ocurrio un error al persistir el objeto de tipo: " + clase.getClass().getSimpleName());

        } finally {
            desconectar();
        }

    }

}
