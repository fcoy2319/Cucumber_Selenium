package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutomationPage extends BasePage{
    //private By pageTitleLocator = By.className("page-title"); --POM
    @FindBy(className = "page-title")
    private WebElement pageTitleLocator;
    private String titlePage = "Category: automation";
    public AutomationPage(WebDriver driver){
        super(driver);
    }
    public boolean isTitleAutomationDisplayed() throws Exception {
        return this.isDisplayed(pageTitleLocator) && this.getText(pageTitleLocator).equals(titlePage);
    }
}
