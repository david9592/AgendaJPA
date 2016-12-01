package comm.agendaJPA.dao.impl;

import comm.agendaJPA.dao.interfaces.AgendaJPADAO;
import comm.agendaJPA.modelo.Contacto;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

public class AgendaJPADAOImpl implements AgendaJPADAO, Serializable {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("AGENDAJPAPU");
    EntityManager em = emf.createEntityManager();

    @Override
    public void guardar(Contacto c) {
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }

    @Override
    public List<Contacto> extraerTodos() {
        List<Contacto> contactos;
        contactos = em.createNamedQuery("AgendaJPA.getAll").getResultList();

        return contactos;
    }

    @Override
    public List<Contacto> buscarDatos(String s) {
        List<Contacto> lista;
        
        lista= em.createNamedQuery("AgendaJPA.searchAll").getResultList();
        
        return lista;
    }

//    @Override
//    public List<Contacto> consultar(Contacto c) {
//        List<Contacto> lista;
//        //Contacto c= em.find(Contacto.class, id);
//        lista= em.createNamedQuery("AgendaJPA.getAll").getResultList();
//        
////        Object[] contacto= new Object[9];
////        contacto= em.createNamedQuery("AgendaJPA.getUser");
//        return lista;
//    }

    @Override
    public void actualizar(Contacto c) {
        em.getTransaction().begin();
        em.merge(c);
        em.getTransaction().commit();
    }

    @Override
    public void borrar(Contacto c) {
        em.getTransaction().begin();
        em.remove(em.merge(c));
        em.getTransaction().commit();
    }
}
