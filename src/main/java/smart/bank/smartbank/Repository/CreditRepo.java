package smart.bank.smartbank.Repository;

import smart.bank.smartbank.entities.DemandeCredit;

import java.util.List;

public interface CreditRepo {
    DemandeCredit save(DemandeCredit creditRequest);

    DemandeCredit findById(Long id);

    DemandeCredit update(DemandeCredit creditRequest);

    void deleteById(Long id);

    List<DemandeCredit> findAll();
}

