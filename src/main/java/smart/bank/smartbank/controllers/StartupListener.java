package smart.bank.smartbank.controllers;


import jakarta.inject.Inject;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import smart.bank.smartbank.services.StatutService;

    @WebListener
    public class StartupListener implements ServletContextListener {

        @Inject
        private StatutService statutService;

        @Override
        public void contextInitialized(ServletContextEvent sce) {
            if(statutService.count() == 0){
                statutService.createStatut("En attente");
                statutService.createStatut("Accepté");
                statutService.createStatut("Rejeté");
            }
        }


    }


