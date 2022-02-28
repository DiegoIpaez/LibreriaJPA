package libreria.persistencia;

import java.util.List;
import javax.persistence.Query;
import libreria.entidades.Cliente;

public class ClienteDao extends Dao<Cliente, Integer> {

    public List<Cliente> listarClientes() {

        conectar();

        List<Cliente> clientes = null;

        try {

            String queryJSQL = "select c from Cliente c";

            Query query = em.createQuery(queryJSQL);

            clientes = query.getResultList();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            desconectar();

        }

        return clientes;
    }
    
    public List<Cliente> BuscarClientePorId(Integer uid) {

        conectar();

        List<Cliente> clientes = null;

        try {

            String queryJSQL = "select c from Cliente c where c.id = :uid ";

            Query query = em.createQuery(queryJSQL).setParameter("uid", uid);

            clientes = query.getResultList();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            desconectar();

        }

        return clientes;
    }

}
