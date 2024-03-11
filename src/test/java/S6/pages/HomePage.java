package S6.pages;

import S6.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    //Agrupar los locators
    By byBtnRegistrarse = By.xpath("//button[@data-testid='signup-button']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Crear los métodos genericos de la page
    public void irARegistrarse(){
        clic(esperarElementoWeb(byBtnRegistrarse));
    }
}
