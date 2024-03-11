package S6.tests;

import S6.pages.HomePage;
import S6.pages.RegisterPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CPs {
    HomePage home;
    RegisterPage register;
    WebDriver driver;

    @BeforeAll
    public static void start(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void preCondioniones(){
        driver = new ChromeDriver();
        home = new HomePage(driver);
        home.cargarSitio("https://open.spotify.com/");
    }

    @AfterEach
    public void posCondiciones(){
        home.cerrarBrowser();
    }

    @Test
    public void CP001_Creacion_Cta_Spotify(){
        home.irARegistrarse();
    }

    @Test
    public void CP002_Error_Creacion_Cta_Spotify_Password_9Caracteres(){
        home.irARegistrarse();
    }


    @Test
    public void CP003_Error_Creacion_Cta_mail_utilizado(){
        home.irARegistrarse();
    }

}
