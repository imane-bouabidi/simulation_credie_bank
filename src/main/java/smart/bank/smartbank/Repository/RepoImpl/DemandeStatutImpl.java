package smart.bank.smartbank.Repository.RepoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import smart.bank.smartbank.Repository.DemandeStatutRepo;
import smart.bank.smartbank.entities.DemandeStatut;

public class DemandeStatutImpl implements DemandeStatutRepo {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(DemandeStatut demandeStatut) {
        entityManager.persist(demandeStatut);
    }
}
