package ejemplos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumEjemplo1 {
    public static void main(String[] args) {
        //Enlazar el driver de chrome a una propiedad de windows que me permita
        //hacer conversar el navegador de chrome con el chromedriver

        String rutaWebDriver = System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe";

        System.out.println(rutaWebDriver);
        //Enlace del ejecutable con el browser via property de windows
        System.setProperty("webdriver.chrome.driver",rutaWebDriver);

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

    }
}
