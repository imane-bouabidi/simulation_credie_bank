package smart.bank.smartbank.controllers;


import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.inject.Inject;
import smart.bank.smartbank.services.StatutService;

    @WebListener
    public class StartupListener implements ServletContextListener {

        @Inject
        private StatutService statutService;

        @Override
        public void contextInitialized(ServletContextEvent sce) {
            if (!statutService.existsByNom("En attente")) {
                statutService.createStatut("En attente");
            }
            if (!statutService.existsByNom("Accepté")) {
                statutService.createStatut("Accepté");
            }
            if (!statutService.existsByNom("Rejeté")) {
                statutService.createStatut("Rejeté");
            }
        }


    }


