package smart.bank.smartbank.services;

import smart.bank.smartbank.Repository.RepoImpl.StatutImpl;
import smart.bank.smartbank.Repository.StatutRepo;
import smart.bank.smartbank.entities.Statut;

import java.util.Optional;

//@
public class StatutService {

    private StatutRepo s =  new StatutImpl();

    public Statut findByNom(String nom) {
        return s.findByNom(nom);
    }

    public void createStatut(String nom) {
        s.save(nom);
    }

    public boolean existsByNom(String nom) {
        return s.existsByNom(nom);
    }
}

