package smart.bank.smartbank.Repository;

import smart.bank.smartbank.entities.DemandeCredit;
import smart.bank.smartbank.entities.DemandeStatut;

import java.time.LocalDate;
import java.util.List;

public interface DemandeStatutRepo {
     void save(DemandeStatut demandeStatut);
     List<DemandeStatut> findByDemandeCreditId(int demandeId);
     List<DemandeCredit> filter(LocalDate date, String statut);

    }
