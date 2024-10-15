package smart.bank.smartbank.Repository;

import smart.bank.smartbank.entities.Statut;

import java.util.Optional;

public interface StatutRepo {
    Statut findByNom(String nom);
    void save(String nom);
    boolean existsByNom(String nom);
    int count();

}
