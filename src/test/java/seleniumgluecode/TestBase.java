package seleniumgluecode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pom.AutomationPage;
import pom.HomePage;

public class TestBase {
    protected WebDriver driver = Hooks.getDriver();
    //protected HomePage homePage = new HomePage(driver); --POM
    //protected AutomationPage automationPage = new AutomationPage(driver); --POM
    protected HomePage homePage = PageFactory.initElements(driver,HomePage.class);
    protected AutomationPage automationPage = PageFactory.initElements(driver, AutomationPage.class);
}
