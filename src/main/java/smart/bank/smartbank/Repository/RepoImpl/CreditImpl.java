package smart.bank.smartbank.Repository.RepoImpl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import smart.bank.smartbank.Repository.CreditRepo;
import smart.bank.smartbank.config.JPAUtil;
import smart.bank.smartbank.entities.DemandeCredit;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CreditImpl implements CreditRepo {

    @Transactional
    @Override
    public DemandeCredit save(DemandeCredit creditRequest) {
    EntityManager em = JPAUtil.getEntityManager();
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

    @Transactional
    @Override
    public Optional<DemandeCredit> findById(Long id) {
    EntityManager em = JPAUtil.getEntityManager();
        try {
            DemandeCredit demande = em.find(DemandeCredit.class, id);
            return Optional.ofNullable(demande);
        } finally {
            em.close();
        }
    }

    @Transactional
    @Override
    public DemandeCredit update(DemandeCredit creditRequest) {
    EntityManager em = JPAUtil.getEntityManager();
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

    @Transactional
    @Override
    public void deleteById(Long id) {
    EntityManager em = JPAUtil.getEntityManager();
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

    @Transactional
    @Override
    public List<DemandeCredit> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("FROM DemandeCredit", DemandeCredit.class).getResultList();
        } finally {
            em.close();
        }
    }



}
