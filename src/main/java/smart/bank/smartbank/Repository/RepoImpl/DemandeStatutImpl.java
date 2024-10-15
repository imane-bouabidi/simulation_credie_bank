package smart.bank.smartbank.Repository.RepoImpl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import smart.bank.smartbank.Repository.DemandeStatutRepo;
import smart.bank.smartbank.config.JPAUtil;
import smart.bank.smartbank.entities.DemandeCredit;
import smart.bank.smartbank.entities.DemandeStatut;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class DemandeStatutImpl implements DemandeStatutRepo {

    @PersistenceContext
    private EntityManager em = JPAUtil.getEntityManager();

    @Transactional
    public void save(DemandeStatut demandeStatut) {
        em.persist(demandeStatut);
    }

    @Transactional
    public List<DemandeStatut> findByDemandeCreditId(int demandeId) {
        String query = "SELECT ds FROM DemandeStatut ds WHERE ds.demandeCredit.id = :demandeId ORDER BY ds.dateChangement DESC";
        return em.createQuery(query, DemandeStatut.class)
                .setParameter("demandeId", demandeId)
                .getResultList();
    }

    @Override
    public List<DemandeCredit> filter(LocalDate date, String statut) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            String queryStr = "FROM DemandeStatut d WHERE d.dateChangement = :date AND d.statut = :statut";
            return em.createQuery(queryStr, DemandeCredit.class)
                    .setParameter("date", date)
                    .setParameter("statut", statut)
                    .getResultList();
        } finally {
            em.close();
        }
    }
}
