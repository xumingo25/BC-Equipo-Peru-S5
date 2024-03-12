package S6.pages;

import S6.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    //Centralizar los By
    By locatorTxtCorreo = By.id("username");
    By locatorTxtPassword = By.name("new-password");
    By locatorBtnCerrarPopUp = By.xpath("//button[@aria-label=\"Cerrar\"]");
    By locatorBtnSiguiente = By.xpath("//button[@data-testid='submit']");
    By locatorUsername = By.id("displayName");
    By locatorDiaNac = By.xpath("//input[@placeholder='dd']");
    By locatorAnnioNac = By.xpath("//input[@placeholder='aaaa']");
    By locatorMesNac = By.id("month");
    By locatorGeneros = By.xpath("//label[contains(@for,'gender_option')]");
    By locatorCheckbox = By.xpath("//label[contains(@for,'checkbox-')]");
    By locatorErrorMail = By.xpath("//span[contains(text(),'Esta dire')]");
    By locatorLabelCaracteresPassword = By.xpath("//li[3]");


    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void ingresarEmail(String email){
        esperarXsegundos(500);
        agregarTexto(esperarElementoWeb(locatorTxtCorreo),email);
    }

    public void ingresarPassword(String password){
        if(estaDesplegado(esperarElementoWeb(locatorBtnCerrarPopUp))){
            clic(esperarElementoWeb(locatorBtnCerrarPopUp));
        }
        esperarXsegundos(500);
        agregarTexto(esperarElementoWeb(locatorTxtPassword),password);
    }

    public void siguiente(){
        esperarXsegundos(500);
        clic(esperarElementoWeb(locatorBtnSiguiente));
    }

    public String errorMailIngresado(){
        return obtenerTexto(esperarElementoWeb(locatorErrorMail));
    }

    public String error9CaracteresPassword(){
        return obtenerTexto(esperarElementoWeb(locatorLabelCaracteresPassword));
    }


    //Crear los métodos
    public void crearCtaSpotify(String email,String password,String username,String dia,String mes,String annio,int genero,boolean checkCompartir,boolean checkMarketing){
        esperarXsegundos(500);
        agregarTexto(esperarElementoWeb(locatorTxtCorreo),email);
        esperarXsegundos(500);
        clic(esperarElementoWeb(locatorBtnSiguiente));
        esperarXsegundos(500);
        if(estaDesplegado(esperarElementoWeb(locatorBtnCerrarPopUp))){
            clic(esperarElementoWeb(locatorBtnCerrarPopUp));
        }
        esperarXsegundos(500);
        agregarTexto(esperarElementoWeb(locatorTxtPassword),password);
        esperarXsegundos(500);
        clic(esperarElementoWeb(locatorBtnSiguiente));
        esperarXsegundos(500);
        agregarTexto(esperarElementoWeb(locatorUsername),username);
        esperarXsegundos(500);
        agregarTexto(esperarElementoWeb(locatorDiaNac),dia);
        esperarXsegundos(500);
        seleccionarCmbPorValue(esperarElementoWeb(locatorMesNac),mes);
        esperarXsegundos(500);
        agregarTexto(esperarElementoWeb(locatorAnnioNac),annio);
        esperarXsegundos(500);
        clic(esperarElementoWeb(buscarElementosWeb(locatorGeneros).get(genero)));
        clic(esperarElementoWeb(locatorBtnSiguiente));
        esperarXsegundos(500);
        if(checkMarketing){
            clic(esperarElementoWeb(buscarElementosWeb(locatorCheckbox).get(0)));
        }
        if(checkCompartir){
            clic(esperarElementoWeb(buscarElementosWeb(locatorCheckbox).get(1)));
        }
        esperarXsegundos(500);
        clic(esperarElementoWeb(locatorBtnSiguiente));

    }
}
