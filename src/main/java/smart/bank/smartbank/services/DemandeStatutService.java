package smart.bank.smartbank.services;

import jakarta.enterprise.context.ApplicationScoped;
import smart.bank.smartbank.Repository.DemandeStatutRepo;
import smart.bank.smartbank.Repository.RepoImpl.DemandeStatutImpl;
import smart.bank.smartbank.entities.DemandeCredit;
import smart.bank.smartbank.entities.DemandeStatut;
import jakarta.inject.Inject;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class DemandeStatutService {

    @Inject
    private DemandeStatutRepo s;

    public void save(DemandeStatut demandeStatut) {
        s.save(demandeStatut);
    }

    public List<DemandeStatut> getHistoriqueStatuts(int demandeId) {
        return s.findByDemandeCreditId(demandeId);
    }
    public List<DemandeCredit> filter(LocalDate date, String statut) {
        return s.filter(date, statut);
    }
}
