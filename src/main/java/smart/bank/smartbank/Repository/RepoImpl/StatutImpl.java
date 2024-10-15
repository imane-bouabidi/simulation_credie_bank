package smart.bank.smartbank.Repository.RepoImpl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import smart.bank.smartbank.Repository.StatutRepo;
import smart.bank.smartbank.config.JPAUtil;
import smart.bank.smartbank.entities.Statut;

@ApplicationScoped
public class StatutImpl implements StatutRepo {
    @PersistenceContext
    private EntityManager em;

    public StatutImpl() {
        this.em = JPAUtil.getEntityManager();
    }
    @Transactional
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

    @Transactional
    @Override
    public void save(String nom){
        Statut statut = new Statut();
        statut.setNom(nom);
        em.persist(statut);
    }
    @Transactional
    public boolean existsByNom(String nom) {
        return findByNom(nom) != null;
    }
    public int count(){
        Long result = em.createQuery("SELECT COUNT(s) FROM Statut s", Long.class).getSingleResult();
        return result.intValue();
    }
}
