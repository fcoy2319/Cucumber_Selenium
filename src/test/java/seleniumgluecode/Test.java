package seleniumgluecode;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class Test extends TestBase{

    @Given("^Usuario se encuentra en la página home de imalittletester$")
    public void usuario_se_encuentra_en_la_página_home_de_imalittletester() throws Throwable {
         Assert.assertTrue(homePage.homePageIsDisplayed());
    }

    @When("^Hace click en el botón The Little Tester Comics$")
    public void hace_click_en_el_botón_The_Little_Tester_Comics() throws Throwable {
        homePage.clickOnTitleAutomation();
    }

    @Then("^Se debe redirigir a la pantalla comics$")
    public void se_debe_redirigir_a_la_pantalla_comics() throws Throwable {
        Assert.assertTrue("No se redirecciono ok a la pagina automation", automationPage.isTitleAutomationDisplayed());
    }
}
