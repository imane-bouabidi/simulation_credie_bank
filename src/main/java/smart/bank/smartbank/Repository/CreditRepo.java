package smart.bank.smartbank.Repository;

import smart.bank.smartbank.entities.DemandeCredit;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CreditRepo {
    DemandeCredit save(DemandeCredit creditRequest);

    Optional<DemandeCredit> findById(Long id);

    DemandeCredit update(DemandeCredit creditRequest);

    void deleteById(Long id);

    List<DemandeCredit> findAll();
}

