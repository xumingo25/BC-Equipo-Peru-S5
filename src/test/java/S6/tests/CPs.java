package S6.tests;

import S6.pages.HomePage;
import S6.pages.RegisterPage;
import S6.utils.FixEncoding;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
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
        register = new RegisterPage(driver);
        home.cargarSitio("https://open.spotify.com/");
        home.maximizarBrowser();
    }

    @AfterEach
    public void posCondiciones(){
        //home.cerrarBrowser();
    }

    @Test
    public void CP001_Creacion_Cta_Spotify(){
        home.irARegistrarse();
        register.crearCtaSpotify("usertest0112@algo.com","123123asds","user test","10","12","2000",0,true,true);
        Assertions.assertEquals(home.obtenerUsername(),"user test");
    }

    @Test
    public void CP002_Error_Creacion_Cta_Spotify_Password_9Caracteres(){
        home.irARegistrarse(); //12345ased
        register.ingresarEmail("usertest01fdsfsd0@algo.com");
        register.siguiente();
        register.ingresarPassword("12345ased");
        register.siguiente();
        Assertions.assertEquals("10 caracteres\n" +
                "Requisito no cumplido. ,",register.error9CaracteresPassword());
    }


    @Test
    public void CP003_Error_Creacion_Cta_mail_utilizado(){
        home.irARegistrarse(); //usertest010@algo.com
        register.ingresarEmail("usertest010@algo.com");
        register.siguiente();
        String Esperado = FixEncoding.corregirEncoding("Esta dirección ya está vinculada a una cuenta. Para continuar, inicia sesión.");
        Assertions.assertEquals(Esperado,register.errorMailIngresado());

    }

}
