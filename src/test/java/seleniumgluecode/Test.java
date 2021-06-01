package seleniumgluecode;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import db.MongoDBHelper;
import org.bson.Document;
import org.junit.Assert;
import utils.LogHelper;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Test extends TestBase{

    private int start;
    private int left;
    MongoDatabase mongoDataBase = null;
    Document mipcgamer = null;
    private static final Logger LOGGER = LogHelper.getLogger(Test.class);


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

    @Given("^Tengo (\\d+) cervezas$")
    public void tengoCervezas(int start) throws Throwable {
        this.start=start;
    }

    @When("^He tomado (\\d+) cervezas$")
    public void heTomadoCervezas(int drink) throws Throwable {
        this.left = this.start - drink;
    }

    @Then("^Deberían quedar (\\d+) ceverzas$")
    public void deberíanQuedarCeverzas(int left) throws Throwable {
        Assert.assertEquals(left, this.left);
        //System.out.println("Left por parametro: "+left);
        //System.out.println("Left calculado: "+this.left);
    }

    @Given("^Un blog llamado \"([^\"]*)\" con el siguiente contenido$")
    public void unBlogLlamadoConElSiguienteContenido(String parametroRandom, String contenido) throws Throwable {
        System.out.println(parametroRandom);
        System.out.println(contenido);
    }

    @Given("^Los siguientes usuarios existentes:$")
    public void losSiguientesUsuariosExistentes(DataTable table) throws Throwable {
        List<List<String>> rows = table.asLists(String.class);
        List<List<String>> rowsWithoutHeading = rows.subList(1,rows.size());

        for (List<String> row : rowsWithoutHeading)
            System.out.println("nombre: " + row.get(0) + " email: " + row.get(1) + " twitter: " + row.get(2));
    }

    @Given("^Me he conectado a la base de datos mipcgamer$")
    public void meHeConectadoALaBaseDeDatosMipcgamer() {
        mongoDataBase = MongoDBHelper.getDataBase("mipcgamer");
    }

    @When("^Obtengo la PC de QA Automation$")
    public void obtengoLaPCDeQAAutomation() {
        MongoCollection<Document> collection = MongoDBHelper.getCollectionFromDb(mongoDataBase, "components");
        mipcgamer = MongoDBHelper.getDocumentBykeyValue(collection, "pc", "PC de QA Automation");
    }

    @Then("^Debo obtener los siguientes componentes \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void deboObtenerLosSiguientesComponentes(String mother, String cpu, String firstSlot, String secondSlot){
        String motherDb = (String) MongoDBHelper.getElementByKeyFromDocument(mipcgamer, "mother");
        LOGGER.log(Level.INFO, "Mother: " + motherDb);
        Assert.assertEquals(mother, motherDb);

        String cpuDb = (String)MongoDBHelper.getElementByKeyFromDocument(mipcgamer, "cpu");
        LOGGER.log(Level.INFO, "Cpu: " + cpuDb);
        Assert.assertEquals(cpu, cpuDb);

        Document rams = (Document)MongoDBHelper.getElementByKeyFromDocument(mipcgamer, "memory");
        String firstSlotDb = (String)MongoDBHelper.getElementByKeyFromDocument(rams, "slot1");
        String secondSlotDb = (String)MongoDBHelper.getElementByKeyFromDocument(rams, "slot2");
        LOGGER.log(Level.INFO, "Primer slot: " + firstSlotDb);
        LOGGER.log(Level.INFO, "Segundo slot: " + secondSlotDb);
        Assert.assertEquals(firstSlot, firstSlotDb);
        Assert.assertEquals(secondSlot, secondSlotDb);

    }
}
