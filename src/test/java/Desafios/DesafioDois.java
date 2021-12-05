package Desafios;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DesafioDois {

    private PageObject pageObject;

    @BeforeEach
    public void beforeEach(){
        this.pageObject = new PageObject();
    }

    @Test
    public void  whenRenameClientThenSuccessfull() {

        pageObject.themeBootstrapV4();
        pageObject.registerClient("Teste Sicredi", "Teste", "Diego Patrício", "51 9999-9999", "Av Assis Brasil, 3970", "Torre D", "Porto Alegre", "RS", "91000-000", "Brasil", "Fixter", "200");
        pageObject.stopTime();
        pageObject.rename("Teste Sicredi");
        assertEquals("Are you sure that you want to delete this 1 item?", pageObject.getMensageDelete());
        pageObject.stopTime();
        pageObject.deleteSucessFull();
        assertEquals("Your data has been successfully deleted from the database.",pageObject.getMensageDeleteSucessFull());
        pageObject.stopTime();
    }


    @AfterEach
    public void afterEach(){
        this.pageObject.quitBrowser();
    }
}
