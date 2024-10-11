package smart.bank.smartbank.Repository.RepoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import smart.bank.smartbank.Repository.DemandeStatutRepo;
import smart.bank.smartbank.config.JPAUtil;
import smart.bank.smartbank.entities.DemandeStatut;

public class DemandeStatutImpl implements DemandeStatutRepo {

    @PersistenceContext
    private EntityManager em = JPAUtil.getEntityManager();

    public void save(DemandeStatut demandeStatut) {
        em.persist(demandeStatut);
    }
}
