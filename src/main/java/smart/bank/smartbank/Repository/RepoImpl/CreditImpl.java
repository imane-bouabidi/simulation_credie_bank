package smart.bank.smartbank.Repository.RepoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import smart.bank.smartbank.Repository.CreditRepo;
import smart.bank.smartbank.config.JPAUtil;
import smart.bank.smartbank.entities.DemandeCredit;

import java.util.List;
import java.util.Optional;

public class CreditImpl implements CreditRepo {
        @PersistenceContext
        EntityManager em = JPAUtil.getEntityManager();
    @Override
    public DemandeCredit save(DemandeCredit creditRequest) {
        try {
            em.getTransaction().begin();
            em.persist(creditRequest);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Erreur lors de la création de la demande de crédit", e);
        } finally {
            em.close();
        }
        return creditRequest;
    }

    @Override
    public Optional<DemandeCredit> findById(Long id) {
        try {
            DemandeCredit demande = em.find(DemandeCredit.class, id);
            return Optional.ofNullable(demande);
        } finally {
            em.close();
        }
    }

    @Override
    public DemandeCredit update(DemandeCredit creditRequest) {
        try {
            em.getTransaction().begin();
            DemandeCredit updatedDemandeCredit = em.merge(creditRequest);
            em.getTransaction().commit();
            return updatedDemandeCredit;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Erreur lors de la mise à jour de la demande de crédit", e);
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            DemandeCredit creditRequest = em.find(DemandeCredit.class, id);
            if (creditRequest != null) {
                em.getTransaction().begin();
                em.remove(creditRequest);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Erreur lors de la suppression de la demande de crédit", e);
        } finally {
            em.close();
        }
    }

    @Override
    public List<DemandeCredit> findAll() {
        try {
            return em.createQuery("FROM DemandeCredit", DemandeCredit.class).getResultList();
        } finally {
            em.close();
        }
    }
}
