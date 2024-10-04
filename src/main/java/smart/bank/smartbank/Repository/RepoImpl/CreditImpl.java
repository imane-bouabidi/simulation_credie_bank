package smart.bank.smartbank.Repository.RepoImpl;

import jakarta.persistence.EntityManager;
import smart.bank.smartbank.Repository.CreditRepo;
import smart.bank.smartbank.config.JPAUtil;
import smart.bank.smartbank.entities.DemandeCredit;

import java.util.List;

public class CreditImpl implements CreditRepo {

    @Override
    public DemandeCredit save(DemandeCredit creditRequest) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(creditRequest);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return creditRequest;
    }

    @Override
    public DemandeCredit findById(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(DemandeCredit.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public DemandeCredit update(DemandeCredit creditRequest) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            DemandeCredit updatedDemandeCredit = em.merge(creditRequest);
            em.getTransaction().commit();
            return updatedDemandeCredit;
        } finally {
            em.close();
        }
    }

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
        } finally {
            em.close();
        }
    }

    @Override
    public List<DemandeCredit> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("FROM DemandeCredit ", DemandeCredit.class).getResultList();
        } finally {
            em.close();
        }
    }

}
