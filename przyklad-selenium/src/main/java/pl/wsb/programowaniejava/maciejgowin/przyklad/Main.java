package pl.wsb.programowaniejava.maciejgowin.przyklad;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.ryanair.com/gb/en");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        String title = driver.getTitle();
        if (title == null || !title.contains("Official Ryanair")) {
            LOGGER.warn("FAILED: wrong website title");
        }

        try {
            WebElement policyAgreeButton = driver.findElement(By.className("cookie-popup-with-overlay__button"));
            policyAgreeButton.click();
        } catch (Exception ex) {
            LOGGER.warn("FAILED: unable to locate policy agree button");
        }

        try {
            WebElement ourPartnersHeader = driver.findElement(By.className("partners-cards-list__header"));
            String ourPartners = ourPartnersHeader.getText();
            if (ourPartners == null || !ourPartners.contains("Our Partners Other")) {
                LOGGER.warn("FAILED: wrong our partners text");
            }
        } catch (Exception ex) {
            LOGGER.warn("FAILED: unable to locate our partners header");
        }

        driver.quit();
    }
}
