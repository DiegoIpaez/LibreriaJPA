package libreria.persistencia;

import java.util.List;
import javax.persistence.Query;
import libreria.entidades.Editorial;


public class EditorialDao extends Dao<Editorial, Integer>{
    
    public List<Editorial> listarEditoriales(){
        
        conectar();
    
        List<Editorial> editoriales = null;
        
        try {
            
            String queryJSQL = "select e from Editorial e";
            
            Query query = em.createQuery(queryJSQL);
            
            editoriales = query.getResultList();
            
            
        } catch (Exception e) {
            
            e.printStackTrace();
            
        }finally{
            
        desconectar();
        
        }
    
        return editoriales;
    }
    
    public List<Editorial> buscarEditorialesPorId(Integer id){
        
        conectar();
    
        List<Editorial> editoriales = null;
        
        try {
            
            String queryJSQL = "select e from Editorial e where e.id = :uid ";
            
            Query query = em.createQuery(queryJSQL).setParameter("uid", id);
            
            editoriales = query.getResultList();
            
            
        } catch (Exception e) {
            
            e.printStackTrace();
            
        }finally{
            
        desconectar();
        
        }
    
        return editoriales;
    }
    
}
