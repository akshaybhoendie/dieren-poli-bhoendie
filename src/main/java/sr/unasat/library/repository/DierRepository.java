package sr.unasat.library.repository;

import sr.unasat.library.entity.Dier;
import sr.unasat.library.entity.Dier;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class DierRepository {

    private EntityManager entityManager;

    public DierRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public List<Dier> getAllDieren(){
        String query = "select g from Dier g";
        TypedQuery<Dier> typedQuery = entityManager.createQuery(query, Dier.class);
        List<Dier> dieren = typedQuery.getResultList();
        return dieren;
    }

    public Dier createDier(Dier dier){
        entityManager.getTransaction().begin();
        entityManager.merge(dier);
        entityManager.getTransaction().commit();

        return dier;
    }

    public int deleteDier(Long dierId){
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Dier g SET g.overleden = 0 WHERE g.id = :dierId");
        query.setParameter("dierId", dierId);
        int updatedRecords = query.executeUpdate();
        entityManager.getTransaction().commit();

        return updatedRecords;
    }

    public Dier updateDier(Dier dier){
        entityManager.getTransaction().begin();
        entityManager.merge(dier);
        entityManager.getTransaction().commit();

        return dier;
    }

    public Dier findDierById(Long dierId){
        String sqlQuery = "SELECT g FROM Dier g WHERE g.id = :dierId";
        TypedQuery<Dier> query = entityManager.createQuery(sqlQuery, Dier.class);
        query.setParameter("dierId", dierId);
        Dier dier = query.getSingleResult();

        return dier;
    }

    public List<Dier> findDierenOfOwnerByOwnerId(Long ownerId){
        String sqlQuery = "SELECT g FROM Dier g WHERE g.lid_id = :ownerId";
        TypedQuery<Dier> query = entityManager.createQuery(sqlQuery, Dier.class);
        query.setParameter("ownerId", ownerId);
        List<Dier> resultList = query.getResultList();

        return resultList;
    }
}
