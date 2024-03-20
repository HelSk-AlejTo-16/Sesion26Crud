package mx.utng.session26.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.session26.model.entity.Directivo;
/*
 * Clase repositorio o dao, utilizare la 
 * anotacion @Repository
 */

@Repository
public class DirectivoDaoImpl implements IDirectivoDao{

    //Entity Manager y contexto de persistencia
    //Guarda internamente todas las entidads y
    //utiliza como una cache datos de BD
    //@PersistenceContext
    @Autowired
    private EntityManager em;


    @SuppressWarnings("unchecked")
    @Override
    public List<Directivo> list() {
        return em.createQuery("from Directivo").getResultList();
    }

    @Override
    public void save(Directivo directivo) {
        System.out.println("Directivo id="+directivo.getId());
        if(directivo.getId() != null && directivo.getId() >0){
            //Actualizo estudiante
            em.merge(directivo);
        }else{
            //Creamos nuevo estudiante en la base
            em.persist(directivo);
        }
    }

    @Override
    public Directivo getById(Long id) {
        return em.find(Directivo.class, id);
    }

    @Override
    public void delete(Long id) {
        Directivo directivo = getById(id);
        em.remove(directivo);
    }

    
}