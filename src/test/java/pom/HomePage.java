package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
   private String titleHomePage = "imalittletester – Testing. With Java, Selenium, TestNG, Maven, Spring, IntelliJ and friends.";
   //private By titleComicsLocator = By.id("menu-item-257"); --POM
   @FindBy(id = "menu-item-257")
   private WebElement titleComicsLocator;

    public HomePage(WebDriver driver){
        super(driver);
    }
    public boolean homePageIsDisplayed() throws Exception {
        return this.getTitle().equals(titleHomePage);
    }
    public void clickOnTitleAutomation() throws Exception {
        this.click(titleComicsLocator);
    }
}

