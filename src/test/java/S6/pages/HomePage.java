package S6.pages;

import S6.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    //Agrupar los locators
    By byBtnRegistrarse = By.xpath("//button[@data-testid='signup-button']");
    By byLabelUsername = By.xpath("//button[@data-testid=\"user-widget-link\"]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Crear los métodos genericos de la page
    public void irARegistrarse(){
        clic(esperarElementoWeb(byBtnRegistrarse));
    }

    public String obtenerUsername(){
        return obtenerAtributo(esperarElementoWeb(byLabelUsername),"aria-label");
    }
}
