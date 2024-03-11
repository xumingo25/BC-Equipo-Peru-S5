package S5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CPsSpotify {
    WebDriver driver;
    WebDriverWait espera;

    //@BeforeAll
    public static void init(){
        WebDriverManager.chromedriver().setup();
    }

    //@BeforeEach
    void preCondiciones(){
        driver = new ChromeDriver();
        espera = new WebDriverWait(driver,10);
        driver.get("https://open.spotify.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    //@AfterEach
    void posCondiciones() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }


    //@Test
    public void CP001_Creacion_Cta_Spotify() throws InterruptedException {
        //WebElement btnRegistrarse = driver.findElement(By.xpath("//button[@data-testid='signup-button']"));
        WebElement btnRegistrarse = espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='signup-button']")));
        btnRegistrarse.click();

        //WebElement txtCorreo = driver.findElement(By.id("username"));
        WebElement txtCorreo = espera.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        txtCorreo.sendKeys("user09sdgdfgfsdf@algo.com");
        //user09sdfsdf@algo.com
        WebElement cerrarPopUp = espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label=\"Cerrar\"]")));

        if(cerrarPopUp.isDisplayed()){
            cerrarPopUp.click();
        }

        Thread.sleep(1000);



        WebElement btnSiguiente = espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='submit']")));
        btnSiguiente.click();

        WebElement txtPassword = espera.until(ExpectedConditions.presenceOfElementLocated(By.name("new-password")));
        txtPassword.sendKeys("qwer123456");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement btnSiguiente1 = espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='submit']")));
        btnSiguiente1.click();

        WebElement txtUsername = espera.until(ExpectedConditions.presenceOfElementLocated(By.id("displayName")));
        txtUsername.sendKeys("Pobre Domingo");


        WebElement txtDia = espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='dd']")));
        txtDia.sendKeys("31");

        WebElement txtAnnio = espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='aaaa']")));
        txtAnnio.sendKeys("2000");

        WebElement cmbMes = espera.until(ExpectedConditions.elementToBeClickable(By.id("month")));
        Select selectorMes = new Select(cmbMes);

        selectorMes.selectByVisibleText("Diciembre");

        List<WebElement> generos = espera.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//label[contains(@for,'gender_option')]")));

        generos.get(0).click();
        Thread.sleep(1000);
        generos.get(1).click();
        Thread.sleep(1000);
        generos.get(2).click();
        Thread.sleep(1000);
        generos.get(3).click();
        Thread.sleep(1000);
        generos.get(4).click();
        Thread.sleep(1000);
        generos.get(0).click();

        WebElement btnSiguiente2 = espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='submit']")));
        btnSiguiente2.click();

        Thread.sleep(1000);

        List<WebElement> checks = espera.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//label[contains(@for,'checkbox-')]")));

        if(checks.size()==2){
            checks.get(0).click();
            Thread.sleep(1000);
            checks.get(1).click();
            Thread.sleep(1000);
            checks.get(0).click();
            Thread.sleep(1000);
            checks.get(1).click();
            Thread.sleep(1000);
            checks.get(0).click();
            Thread.sleep(1000);
            checks.get(1).click();
            Thread.sleep(1000);
        }

        WebElement btnReg = espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='submit']")));
        btnReg.click();

        WebElement btnUsername = espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label=\"Pobre Domingo\"]")));

        String userName = btnUsername.getAttribute("aria-label");

        Assertions.assertEquals("Pobre Domingo",userName);

    }


    //@Test
    public void CP002_Error_Creacion_Cta_Spotify_Password_9Caracteres(){
        //WebElement btnRegistrarse = driver.findElement(By.xpath("//button[@data-testid='signup-button']"));
        WebElement btnRegistrarse = espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='signup-button']")));
        btnRegistrarse.click();

        //WebElement txtCorreo = driver.findElement(By.id("username"));
        WebElement txtCorreo = espera.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        txtCorreo.sendKeys("user09sdfsdf@algo.com");

        WebElement btnSiguiente = espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='submit']")));
        btnSiguiente.click();

        WebElement txtPassword = espera.until(ExpectedConditions.presenceOfElementLocated(By.name("new-password")));
        txtPassword.sendKeys("qwer12345");

        WebElement btnSiguiente2 = espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='submit']")));
        btnSiguiente2.click();

        WebElement checkCaracteresOK = espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[3]")));
        Assertions.assertTrue(!checkCaracteresOK.isSelected());
    }
}
