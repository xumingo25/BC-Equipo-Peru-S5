package S6.tests;

import S6.pages.HomePage;
import S6.pages.RegisterPage;
import S6.utils.DataDriven;
import S6.utils.FixEncoding;
import S6.utils.PropertiesManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class CPs {
    HomePage home;
    RegisterPage register;
    WebDriver driver;
    ArrayList<String> dataCPs; //null

    @BeforeAll
    public static void start(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void preCondioniones(){
        dataCPs = new ArrayList<String>(); //0
        driver = new ChromeDriver();
        home = new HomePage(driver);
        register = new RegisterPage(driver);
        home.cargarSitio(PropertiesManager.obtenerProperty("url"));
        home.maximizarBrowser();
    }

    @AfterEach
    public void posCondiciones(){
        home.cerrarBrowser();
    }

    @Test
    public void CP001_Creacion_Cta_Spotify(){
        dataCPs = DataDriven.prepararData("CP001_Creacion_Cta_Spotify");

        home.irARegistrarse();
        register.crearCtaSpotify(dataCPs.get(1),dataCPs.get(2),dataCPs.get(3),dataCPs.get(4),dataCPs.get(5),dataCPs.get(6),Integer.parseInt(dataCPs.get(7)), Boolean.parseBoolean(dataCPs.get(8)),Boolean.parseBoolean(dataCPs.get(9)));
        Assertions.assertEquals(dataCPs.get(10),home.obtenerUsername());
    }

    @Test
    public void CP002_Error_Creacion_Cta_Spotify_Password_9Caracteres(){
        dataCPs = DataDriven.prepararData("CP002_Error_Creacion_Cta_Spotify_Password_9Caracteres");
        home.irARegistrarse(); //12345ased
        register.ingresarEmail(dataCPs.get(1));
        register.siguiente();
        register.ingresarPassword(dataCPs.get(2));
        register.siguiente();
        System.out.println(dataCPs.get(3));
        System.out.println(register.error9CaracteresPassword());
        Assertions.assertEquals(dataCPs.get(3),register.error9CaracteresPassword());
    }


    @Test
    public void CP003_Error_Creacion_Cta_mail_utilizado(){
        dataCPs = DataDriven.prepararData("CP003_Error_Creacion_Cta_mail_utilizado");
        home.irARegistrarse(); //usertest010@algo.com
        register.ingresarEmail(dataCPs.get(1));
        register.siguiente();
        String Esperado = dataCPs.get(2);
        Assertions.assertEquals(Esperado,register.errorMailIngresado());

    }

}
