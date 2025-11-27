package sqasa.reto.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    public static WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();

        // Detectar si estamos en CI (GitHub Actions)
        boolean isCI = System.getenv("CI") != null || System.getenv("GITHUB_ACTIONS") != null;

        if (isCI) {
            chromeOptions.addArguments("--headless=new");   // modo headless moderno
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-dev-shm-usage");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--window-size=1920,1080");
        } else {
            chromeOptions.addArguments("--start-maximized");
        }

        // Opciones comunes
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--remote-allow-origins=*");

        return new ChromeDriver(chromeOptions);
    }
}
