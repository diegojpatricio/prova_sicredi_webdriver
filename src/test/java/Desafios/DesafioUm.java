package Desafios;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class DesafioUm {

    private PageObject pageObject;

    @BeforeEach
    public void beforeEach(){
        this.pageObject = new PageObject();
    }

    @Test
    public void  whenRegisterClientThenSuccessfull(){

        pageObject.themeBootstrapV4();
        pageObject.registerClient("Teste Sicredi", "Teste", "Diego Patrício", "51 9999-9999", "Av Assis Brasil, 3970", "Torre D", "Porto Alegre", "RS", "91000-000", "Brasil", "Fixter", "200");
        pageObject.stopTime();
        assertEquals("Your data has been successfully stored into the database. Edit Record or Go back to list", pageObject.getMensage());
    }

    @AfterEach
    public void afterEach(){
        this.pageObject.quitBrowser();
    }
}
