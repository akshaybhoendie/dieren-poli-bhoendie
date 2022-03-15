package sr.unasat.library.repository;

import sr.unasat.library.entity.Gebruiker;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class GebruikerRepository {

    private EntityManager entityManager;

    public GebruikerRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public List<Gebruiker> getAllActiveUsers(){
        String query = "select g from Gebruiker g where g.actief = true";
        TypedQuery <Gebruiker> typedQuery = entityManager.createQuery(query, Gebruiker.class);
        List<Gebruiker> activeGebruikers = typedQuery.getResultList();
        return activeGebruikers;
    }

    public Gebruiker createGebruiker(Gebruiker gebruiker){
        entityManager.getTransaction().begin();
        entityManager.merge(gebruiker);
        entityManager.getTransaction().commit();

        return gebruiker;
    }

    public int deleteGebruiker(Long gebruikerId){
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Gebruiker g SET g.actief = 0 WHERE g.id = :gebruikerId");
        query.setParameter("gebruikerId", gebruikerId);
        int updatedRecords = query.executeUpdate();
        entityManager.getTransaction().commit();

        return updatedRecords;
    }

    public Gebruiker updateGebruiker(Gebruiker gebruiker){
        entityManager.getTransaction().begin();
        entityManager.merge(gebruiker);
        entityManager.getTransaction().commit();

        return gebruiker;
    }

    public Gebruiker findGebruikerById(Long gebruikerId){
        String sqlQuery = "SELECT g FROM Gebruiker g WHERE g.id = :gebruikerId";
        TypedQuery<Gebruiker> query = entityManager.createQuery(sqlQuery, Gebruiker.class);
        query.setParameter("gebruikerId", gebruikerId);
        Gebruiker gebruiker = query.getSingleResult();

        return gebruiker;
    }

}
