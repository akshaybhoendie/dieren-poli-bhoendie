package sr.unasat.library.repository;

import sr.unasat.library.entity.Lidmaatschap;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class LidmaatschapRepository {

    private EntityManager entityManager;

    public LidmaatschapRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public List<Lidmaatschap> getAllActiveLidmaatschappen(){
        String query = "select g from Lidmaatschap g where g.actief = true";
        TypedQuery<Lidmaatschap> typedQuery = entityManager.createQuery(query, Lidmaatschap.class);
        List<Lidmaatschap> activeLidmaatschappen = typedQuery.getResultList();
        return activeLidmaatschappen;
    }

    public Lidmaatschap createLidmaatschap(Lidmaatschap Lidmaatschap){
        entityManager.getTransaction().begin();
        entityManager.merge(Lidmaatschap);
        entityManager.getTransaction().commit();

        return Lidmaatschap;
    }

    public int deleteLidmaatschap(Long lidmaatschapId){
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Lidmaatschap g SET g.actief = 0 WHERE g.id = :lidmaatschapId");
        query.setParameter("lidmaatschapId", lidmaatschapId);
        int updatedRecords = query.executeUpdate();
        entityManager.getTransaction().commit();

        return updatedRecords;
    }

    public Lidmaatschap updateLidmaatschap(Lidmaatschap lidmaatschap){
        entityManager.getTransaction().begin();
        entityManager.merge(lidmaatschap);
        entityManager.getTransaction().commit();

        return lidmaatschap;
    }

    public Lidmaatschap findLidmaatschapById(Long lidmaatschapId){
        String sqlQuery = "SELECT g FROM Lidmaatschap g WHERE g.id = :lidmaatschapId";
        TypedQuery<Lidmaatschap> query = entityManager.createQuery(sqlQuery, Lidmaatschap.class);
        query.setParameter("lidmaatschapId", lidmaatschapId);
        Lidmaatschap Lidmaatschap = query.getSingleResult();

        return Lidmaatschap;
    }
}
