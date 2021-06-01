package seleniumgluecode;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import runner.browser_manager.DriverManager;
import runner.browser_manager.DriverManagerFactory;
import runner.browser_manager.DriverType;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Hooks {
    private static WebDriver driver;
    private DriverManager driverManager;
    //private static int numberOfCase=0;
    @Before("@browser")
    public void setUp() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("src/test/resources/config.properties"));
        //numberOfCase++;
        //System.out.println("se está ejecutando el escenario número: "+numberOfCase);
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        driver = driverManager.getDriver();
        /* ************************************************************

                              -> Espera Implícita <-
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        ************************************************************ */
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(properties.getProperty("url_base"));
        driver.manage().window().maximize();
    }
    @After("@browser")
    public void tearDown(Scenario scenario){
        //System.out.println("el escenario numero: "+numberOfCase+" se ejecutó");
        if(scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot)driverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot,"image/png");
        }
        driverManager.quitDriver();
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
