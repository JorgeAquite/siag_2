/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Aluca
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "SIAG_2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario iniciarSesion(Usuario us){
        
        String consulta;
        Usuario existe=null;
        try {
            //consulta="FROM Usuario u WHERE u.nombre LIKE ?1 and u.documento LIKE ?2";
            consulta="FROM Usuario u WHERE u.nombre = :nombre and u.documento = :clave";//
            Query query= em.createQuery(consulta);
            query.setParameter("nombre", us.getNombre());
            query.setParameter("clave",  us.getDocumento() );
            
            List<Usuario> lista=query.getResultList();
            if (!lista.isEmpty()) {
               existe=lista.get(0);                
            }
        } catch (Exception e) {
            throw e;
            
        }
        return existe;
    }
    
  
    
}
