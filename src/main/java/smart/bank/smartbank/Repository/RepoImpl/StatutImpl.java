package smart.bank.smartbank.Repository.RepoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import smart.bank.smartbank.Repository.StatutRepo;
import smart.bank.smartbank.config.JPAUtil;
import smart.bank.smartbank.entities.Statut;

import java.util.Optional;

public class StatutImpl implements StatutRepo {
    @PersistenceContext
    EntityManager em = JPAUtil.getEntityManager();


    public Statut findByNom(String nom) {
        try {
            Statut statut = em
                    .createQuery("SELECT s FROM Statut s WHERE s.nom = :nom", Statut.class)
                    .setParameter("nom", nom)
                    .getSingleResult();
            return statut;
        } catch (Exception e) {
            return null;
        }
    }

    public void save(String nom){
        Statut statut = new Statut();
        statut.setNom(nom);
        em.persist(statut);
    }

    public boolean existsByNom(String nom) {
        return findByNom(nom) != null;
    }
}
