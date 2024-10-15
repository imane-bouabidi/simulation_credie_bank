package smart.bank.smartbank.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import smart.bank.smartbank.Repository.StatutRepo;
import smart.bank.smartbank.entities.Statut;

@ApplicationScoped
public class StatutService {

    @Inject
    private StatutRepo s;

    public Statut findByNom(String nom) {
        return s.findByNom(nom);
    }

    public void createStatut(String nom) {
        s.save(nom);
    }

    public boolean existsByNom(String nom) {
        return s.existsByNom(nom);
    }

    public int count(){
        return s.count();
    }
}

