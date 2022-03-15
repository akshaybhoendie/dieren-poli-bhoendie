package sr.unasat.library.repository;

import sr.unasat.library.entity.Dienst;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class DienstRepository {

    private EntityManager entityManager;

    public DienstRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public List<Dienst> getAllActiveDiensten(){
        String query = "select g from Dienst g where g.actief = true";
        TypedQuery<Dienst> typedQuery = entityManager.createQuery(query, Dienst.class);
        List<Dienst> dienstList = typedQuery.getResultList();
        return dienstList;
    }

    public Dienst createDienst(Dienst dienst){
        entityManager.getTransaction().begin();
        entityManager.merge(dienst);
        entityManager.getTransaction().commit();

        return dienst;
    }

    public int deleteDienst(Long dienstId){
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Dienst g SET g.actief = 0 WHERE g.id = :dienstId");
        query.setParameter("dienstId", dienstId);
        int updatedRecords = query.executeUpdate();
        entityManager.getTransaction().commit();

        return updatedRecords;
    }

    public Dienst updateDienst(Dienst dienst){
        entityManager.getTransaction().begin();
        entityManager.merge(dienst);
        entityManager.getTransaction().commit();

        return dienst;
    }

    public Dienst findDienstById(Long dienstId){
        String sqlQuery = "SELECT g FROM Dienst g WHERE g.id = :dienstId";
        TypedQuery<Dienst> query = entityManager.createQuery(sqlQuery, Dienst.class);
        query.setParameter("dienstId", dienstId);
        Dienst dienst = query.getSingleResult();

        return dienst;
    }
}
