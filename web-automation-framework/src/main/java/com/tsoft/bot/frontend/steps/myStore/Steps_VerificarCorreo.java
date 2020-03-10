package com.tsoft.bot.frontend.steps.myStore;

import  com.tsoft.bot.frontend.BaseClass;
import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.utility.ExcelReader;
import com.tsoft.bot.frontend.utility.GenerateWord;
import com.tsoft.bot.frontend.utility.Sleeper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import static com.tsoft.bot.frontend.pageobject.myStore.PageObject_MyStore.*;
import java.util.HashMap;
import java.util.List;

public class Steps_VerificarCorreo extends BaseClass {

    private WebDriver driver;
    private static final String EXCEL_WEB = "excel/StoreOnline.xlsx";
    private static final String VERIFICAR_CORREO = "VerificarCorreo";
    private static final String COLUMNA_URL = "URL";
    private static final String COLUMNA_EMAIL = "Email";
    private static GenerateWord generateWord = new GenerateWord();

    public Steps_VerificarCorreo(){
        this.driver = Hook.getDriver();
    }

    private List<HashMap<String, String>> getData() throws Throwable{
        return ExcelReader.data(EXCEL_WEB, VERIFICAR_CORREO);
    }

    @Given("^Ingresar la URL de la pagina Store \"([^\"]*)\"$")
    public void ingresarLaURLDeLaPaginaStore(String caso_prueba) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        try {
            int myStore = Integer.parseInt(caso_prueba) - 1;
            String url = getData().get(myStore).get(COLUMNA_URL);
            driver.get(url);
            sleep(3500);
            stepPass(driver,"Se inició correctamente la página Store Online");
            generateWord.sendText("Se inició correctamente la página Store Online");
            generateWord.addImageToWord(driver);
        }
        catch (Exception e){
            ExcelReader.writeCellValue(EXCEL_WEB, VERIFICAR_CORREO,1,19,"FAIL");
            stepFail(driver,"Fallo el caso de prueba " + e.getMessage());
            generateWord.sendText("El tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @And("^Hacer clic en Sign In debe mostrar pagina de authenticacion$")
    public void hacerClicEnSignInDebeMostrarPaginaDeAuthenticacion() throws Throwable {
        try {
            click(driver,"linktext",LNK_SINGIN);
            //driver.findElement(LNK_SINGIN).click();
            stepPass(driver,"Se dio clic en el link Sign In");
            generateWord.sendText("Se dio clic en el link Sign In");
            generateWord.addImageToWord(driver);
        }
        catch (Exception e){
            ExcelReader.writeCellValue(EXCEL_WEB, VERIFICAR_CORREO,1,19,"FAIL");
            stepFail(driver,"Falló el caso de prueba" + e.getMessage());
            generateWord.sendText("El tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @When("^Se ingresa un correo electronico \"([^\"]*)\"$")
    public void seIngresaUnCorreoElectronico(String caso_prueba) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        try {
            int myStore = Integer.parseInt(caso_prueba) - 1;
            String email = getData().get(myStore).get(COLUMNA_EMAIL);
            clear(driver,"id",TXT_EMAIL);
            //driver.findElement(TXT_EMAIL).clear();
            sendKeyValue(driver,"id",TXT_EMAIL,email);
            //driver.findElement(TXT_EMAIL).sendKeys(email);
            sleep(3500);
            stepPass(driver,"Se ingresó el email correctamente");
            generateWord.sendText("Se ingresó el email correctamente");
            generateWord.addImageToWord(driver);
        }
        catch (Exception e){
            ExcelReader.writeCellValue(EXCEL_WEB, VERIFICAR_CORREO,1,19,"FAIL");
            stepFail(driver,"El tiempo de espera ha excedido" + e.getMessage());
            generateWord.sendText("El tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @And("^Se da clic en el boton Create an Account$")
    public void seDaClicEnElBotonCreateAnAccount() throws Throwable {
        try {
            //(driver.findElement(BTN_CREATE_ACOUNT).click();
            click(driver,"id",BTN_CREATE_ACOUNT);
            stepPass(driver,"Se dió clic en el botón Create an Account");
            generateWord.sendText("Se dió clic en el botón Create an Account");
            generateWord.addImageToWord(driver);
        }
        catch (Exception e){
            ExcelReader.writeCellValue(EXCEL_WEB, VERIFICAR_CORREO,1,19,"FAIL");
            stepFail(driver,"El tiempo de espera ha excedido " + e.getMessage());
            generateWord.sendText("El tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Then("^Muestra pagina de personal information$")
    public void muestraPaginaDePersonalInformation() throws Throwable {
        try {
            if (isDisplayed(driver,"xpath",LBL_CREATE_ACCOUNT)){
                //if (driver.findElement(LBL_CREATE_ACCOUNT).isDisplayed()){
                stepPass(driver,"Se validó correctamente el correo");
                generateWord.sendText("Se validó correctamente el correo");
                generateWord.addImageToWord(driver);
            }
        }
        catch (Exception e){
            ExcelReader.writeCellValue(EXCEL_WEB, VERIFICAR_CORREO,1,19,"FAIL");
            stepFail(driver,"El tiempo de espera ha excedido" + e.getMessage());
            generateWord.sendText("El tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

}
