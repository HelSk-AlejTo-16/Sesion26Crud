package mx.utng.session26.model.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.session26.model.entity.Paraescolar;


@Repository
public class ParaEscolarDaoImpl implements IParaEscolarDao{
     //Entity Manager y contexto de persistencia
    //Guarda internamente todas las entidads y
    //utiliza como una cache datos de BD
    //@PersistenceContext
    @Autowired
    private EntityManager em;


    @SuppressWarnings("unchecked")
    @Override
    public List<Paraescolar> list() {
        return em.createQuery("from Paraescolar").getResultList();
    }

    @Override
    public void save(Paraescolar paraescolar) {
        if(paraescolar.getId() != null && paraescolar.getId() >0){
            em.merge(paraescolar);
        }else{
            em.persist(paraescolar);
        }
    }

    @Override
    public Paraescolar getById(Long id) {
        return em.find(Paraescolar.class, id);
    }

    @Override
    public void delete(Long id) {
        Paraescolar paraescolar = getById(id);
        em.remove(paraescolar);
    }

    
}
