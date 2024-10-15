package smart.bank.smartbank.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import smart.bank.smartbank.Repository.CreditRepo;
import smart.bank.smartbank.entities.DemandeCredit;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class DemandeCreditService {

    @Inject
    private CreditRepo creditRepo;


    public DemandeCredit createDemande(DemandeCredit demandeCredit) {
        DemandeCredit savedDemande = creditRepo.save(demandeCredit);
        if (savedDemande == null) {
            throw new RuntimeException("Échec de la création de la demande de crédit");
        }
        return savedDemande;
    }

    public Optional<DemandeCredit> getDemandeById(Long id) {
        return creditRepo.findById(id);
    }

    public List<DemandeCredit> getAllDemandes() {
        return creditRepo.findAll();
    }

    public DemandeCredit updateDemande(DemandeCredit demandeCredit) {
        return creditRepo.update(demandeCredit);
    }

    public void deleteDemande(Long id) {
        creditRepo.deleteById(id);
    }



}
