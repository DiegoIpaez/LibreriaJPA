package libreria.persistencia;

import java.util.List;
import javax.persistence.Query;
import libreria.entidades.Prestamo;

public class PrestamoDao extends Dao<Prestamo, Integer> {

    public List<Prestamo> listarPrestamos() {

        conectar();

        List<Prestamo> prestamos = null;

        try {

            String queryJSQL = "select p from Prestamo p";

            Query query = em.createQuery(queryJSQL);

            prestamos = query.getResultList();

        } catch (Exception e) {
        } finally {
            desconectar();
        }

        return prestamos;
    }
    
    public List<Prestamo> buscarPrestamosPorCliente(String nombre) {

        conectar();

        List<Prestamo> prestamos = null;

        try {

            String queryJSQL = "select p from Prestamo p where p.cliente.nombre like :uid";

            Query query = em.createQuery(queryJSQL).setParameter("uid", "%"+nombre+"%");

            prestamos = query.getResultList();

        } catch (Exception e) {
        } finally {
            desconectar();
        }

        return prestamos;
    }

}
