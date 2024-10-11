package smart.bank.smartbank.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import smart.bank.smartbank.Repository.DemandeStatutRepo;
import smart.bank.smartbank.Repository.RepoImpl.DemandeStatutImpl;
import smart.bank.smartbank.entities.DemandeStatut;

public class DemandeStatutService {

    private DemandeStatutRepo s = new DemandeStatutImpl();

    public void save(DemandeStatut demandeStatut) {
        s.save(demandeStatut);
    }
}
