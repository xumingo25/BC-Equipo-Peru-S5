package S6.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    //Wrapper de selenium
    private WebDriver driver;
    private WebDriverWait espera;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    //Métodos que invocan las librerias de selenium
    public WebElement buscarElementoWeb(By localizador){
        return driver.findElement(localizador);
    }

    public List<WebElement> buscarElementosWeb(By localizador){
        return driver.findElements(localizador);
    }

    public void clic(By localizador){
        driver.findElement(localizador).click();
    }

    public void clic(WebElement elemento){
        elemento.click();
    }

    public void esperarXsegundos(int milisegundos){
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public WebElement esperarElementoWeb(By localizador){
        espera = new WebDriverWait(this.driver,30);
        return espera.until(ExpectedConditions.presenceOfElementLocated(localizador));
    }

    public WebElement esperarElementoWeb(WebElement elemento){
        espera = new WebDriverWait(this.driver,30);
        return espera.until(ExpectedConditions.visibilityOf(elemento));
    }

    public void cargarSitio(String url){
        driver.get(url);
    }

    public void cerrarBrowser(){
        driver.quit();
    }

    public void agregarTexto(By localizador,String texto){
        driver.findElement(localizador).sendKeys(texto);
    }

    public void agregarTexto(WebElement elemento,String texto){
        elemento.sendKeys(texto);
    }

    public void maximizarBrowser(){
        driver.manage().window().maximize();
    }

    public String obtenerTexto(WebElement elemento){
        return elemento.getText();
    }

    public String obtenerTexto(By localizador){
        return driver.findElement(localizador).getText();
    }

    public String obtenerAtributo(WebElement elemento,String atributo){
        return elemento.getAttribute(atributo);
    }

    public boolean estaDesplegado(WebElement elemento){
        return elemento.isDisplayed();
    }

    public void seleccionarCmbPorValue(WebElement elemento, String value){
        Select selector = new Select(elemento);
        selector.selectByValue(value);
    }
}

