package com.tsoft.bot.frontend.steps.myStore;

import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.BaseClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.tsoft.bot.frontend.utility.ExcelReader;
import com.tsoft.bot.frontend.utility.ExtentReportUtil;
import com.tsoft.bot.frontend.utility.GenerateWord;
import com.tsoft.bot.frontend.utility.Sleeper;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.List;

import static com.tsoft.bot.frontend.pageobject.myStore.PageObject_MyStore.*;

public class Steps_Login extends BaseClass {

    private static final String EXCEL_WEB = "excel/StoreOnline.xlsx";
    private static final String LOGIN_WEB = "Login";
    private static final String COLUMNA_URL = "URL";
    private static final String COLUMNA_USUARIO = "Usuario";
    private static final String COLUMNA_CONTRASENIA = "Contraseña";
    private static GenerateWord generateWord = new GenerateWord();
    private WebDriver driver;

    public Steps_Login() {
        this.driver = Hook.getDriver();
    }

    private List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(EXCEL_WEB, LOGIN_WEB);
    }

    @Given("^Ingresar a la URL de la pagina Store \"([^\"]*)\"$")
    public void ingresarALaURLDeLaPaginaStore(String casoDePrueba) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        try {
            int myStore = Integer.parseInt(casoDePrueba) - 1;
            String url = getData().get(myStore).get(COLUMNA_URL);
            driver.get(url);
            sleep(3500);
            stepPass(driver, "Se inició correctamente la página Store Online");
            generateWord.sendText("Se inició correctamente la página Store Online");
            generateWord.addImageToWord(driver);
        }catch (Exception e) {
            ExcelReader.writeCellValue(EXCEL_WEB, LOGIN_WEB, 1, 19, "FAIL");
            stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @And("^Hacer clic on Sign In debe mostrar una página de login$")
    public void hacerClicOnSignInDebeMostrarUnaPáginaDeLogin() throws Throwable {
        try {
            //driver.findElement(LNK_SINGIN).click();
            click(driver,"linktext", LNK_SINGIN);
            stepPass(driver, "Se dió clic en el link Sing In");
            generateWord.sendText("Se dió clic en el link Sing In");
            generateWord.addImageToWord(driver);
        }catch (Exception e) {
            ExcelReader.writeCellValue(EXCEL_WEB, LOGIN_WEB, 1, 19, "FAIL");
            stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @When("^Se ingresa el usuario \"([^\"]*)\"$")
    public void seIngresaElUsuario(String casoDePrueba) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        try {
            int myStore = Integer.parseInt(casoDePrueba) - 1;
            String email = getData().get(myStore).get(COLUMNA_USUARIO);
            clear(driver,"id", TXT_USUARIO);
            //driver.findElement(TXT_USUARIO).clear();
            sendKeyValue(driver,"id",TXT_USUARIO,email);
            //driver.findElement(TXT_USUARIO).sendKeys(email);
            sleep(3500);
            stepPass(driver, "Se ingresó el email correcto: " + email);
            generateWord.sendText("Se ingresó el email correcto: " + email);
            generateWord.addImageToWord(driver);
        }catch (Exception e) {
            ExcelReader.writeCellValue(EXCEL_WEB, LOGIN_WEB, 1, 19, "FAIL");
            stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @And("^se ingresa la contraseña \"([^\"]*)\"$")
    public void seIngresaLaContraseña(String casoDePrueba) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        try {
            int myStore = Integer.parseInt(casoDePrueba) - 1;
            String password = getData().get(myStore).get(COLUMNA_CONTRASENIA);
            sendKeyValue(driver,"id", TXT_PASSWORD2,password);
            //driver.findElement(TXT_PASSWORD).sendKeys(password);
            sleep(3500);
            stepPass(driver, "Se ingresó el password correcto " + password);
            generateWord.sendText("Se ingresó el password correcto " + password);
            generateWord.addImageToWord(driver);
        }catch (Exception e) {
            ExcelReader.writeCellValue(EXCEL_WEB, LOGIN_WEB, 1, 19, "FAIL");
            stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @And("^Se da clic en el boton Sing in$")
    public void seDaClicEnElBotonSingIn() throws Throwable {
        try {
            //driver.findElement(BTN_SINGIN).click();
            click(driver,"id", BTN_SINGIN);
            stepPass(driver, "Se dió clic en el botón Sing In");
            generateWord.sendText("Se dió clic en el botón Sing In");
            generateWord.addImageToWord(driver);
        }catch (Exception e) {
            ExcelReader.writeCellValue(EXCEL_WEB, LOGIN_WEB, 1, 19, "FAIL");
            stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Then("^Se valida el logueo correctamente$")
    public void seValidaElLogueoCorrectamente() {
    }
}
