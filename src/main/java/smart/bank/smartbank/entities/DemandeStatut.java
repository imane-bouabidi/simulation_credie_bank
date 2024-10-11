package smart.bank.smartbank.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "demande_statut")
public class DemandeStatut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "demande_credit_id")
    private DemandeCredit demandeCredit;

    @ManyToOne
    @JoinColumn(name = "statut_id")
    private Statut statut;

    @Column(nullable = false)
    private LocalDate dateChangement;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DemandeCredit getDemandeCredit() {
        return demandeCredit;
    }

    public void setDemandeCredit(DemandeCredit demandeCredit) {
        this.demandeCredit = demandeCredit;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public LocalDate getDateChangement() {
        return dateChangement;
    }

    public void setDateChangement(LocalDate dateChangement) {
        this.dateChangement = dateChangement;
    }

}
