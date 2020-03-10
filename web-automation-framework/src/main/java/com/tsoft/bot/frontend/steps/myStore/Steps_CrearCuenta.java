package com.tsoft.bot.frontend.steps.myStore;

import  com.tsoft.bot.frontend.BaseClass;
import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.utility.ExcelReader;
import com.tsoft.bot.frontend.utility.GenerateWord;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import static com.tsoft.bot.frontend.pageobject.myStore.PageObject_MyStore.*;
import java.util.HashMap;
import java.util.List;

public class Steps_CrearCuenta extends BaseClass {

    private WebDriver driver;
    private static final String EXCEL_WEB = "excel/StoreOnline.xlsx";
    private static final String CREAR_CUENTA = "CrearCuenta";
    private static final String FIRST_NAME = "FirstName";
    private static final String LAST_NAME = "LastName";
    private static final String PASSWORD = "Password";
    private static final String DAY_BIRTH = "dBirth";
    private static final String MONTH_BIRTH = "mBirth";
    private static final String YEAR_BIRTH = "yBirth";
    private static final String ADDRESS = "Address";
    private static final String CITY = "City";
    private static final String STATE = "State";
    private static final String ZIP_CODE = "ZipCode";
    private static final String COUNTRY = "Country";
    private static final String MOBILE_PHONE = "MobilePhone";
    private static final String REFERENCE_ADDRESS = "ReferenceAddress";
    private static GenerateWord generateWord = new GenerateWord();

    public Steps_CrearCuenta(){
        this.driver = Hook.getDriver();
    }
    private List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(EXCEL_WEB, CREAR_CUENTA);
    }

    @Given("^Completar datos personales \"([^\"]*)\"$")
    public void completarDatosPersonales(String caso_prueba) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        try {
            int myStore = Integer.parseInt(caso_prueba) - 1;
            String firstName = getData().get(myStore).get(FIRST_NAME);
            String lastName = getData().get(myStore).get(LAST_NAME);
            String password = getData().get(myStore).get(PASSWORD);
            String dBirth = getData().get(myStore).get(DAY_BIRTH);
            String mBirth = getData().get(myStore).get(MONTH_BIRTH);
            String yBirth = getData().get(myStore).get(YEAR_BIRTH);
            String address = getData().get(myStore).get(ADDRESS);
            String city = getData().get(myStore).get(CITY);
            String state = getData().get(myStore).get(STATE);
            String zipCode = getData().get(myStore).get(ZIP_CODE);
            String country = getData().get(myStore).get(COUNTRY);
            String mobilePhone = getData().get(myStore).get(MOBILE_PHONE);
            String referenceAddress = getData().get(myStore).get(REFERENCE_ADDRESS);
            limpiarCampos();
            click(driver,"id", RADIO_TITLE);
            sendKeyValue(driver,"id", TXT_FIRST_NAME, firstName);
            sendKeyValue(driver,"id", TXT_LAST_NAME, lastName);
            sendKeyValue(driver,"id", TXT_PASSWORD1, password);
            selectByValue(driver,"id", SELECT_DBIRTH, dBirth);
            selectByValue(driver, "id", SELECT_MBIRTH, mBirth);
            selectByValue(driver,"id", SELECT_YBIRTH, yBirth);
            sendKeyValue(driver,"id", TXT_ADDRESS, address);
            sendKeyValue(driver,"id", TXT_CITY, city);
            selectByVisibleText(driver, SELECT_STATE, state);
            sendKeyValue(driver,"id", TXT_ZIP_CODE, zipCode);
            selectByVisibleText(driver, SELECT_COUNTRY, country);
            sendKeyValue(driver,"id", TXT_MOBILE_PHONE, mobilePhone);
            sendKeyValue(driver,"id", TXT_REFERENCE_ADDRESS, referenceAddress);
            sleep(3500);
            stepPass(driver,"Se ingresó los datos personales correctamente");
            generateWord.sendText("Se ingresó los datos personales correctamente");
            generateWord.addImageToWord(driver);
        }
        catch (Exception e){
            ExcelReader.writeCellValue(EXCEL_WEB, CREAR_CUENTA, 1, 19, "FAIL");
            stepFail(driver, "El tiempo de espera ha excedido " + e.getMessage());
            generateWord.sendText("El tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @And("^Se da clic en el boton register$")
    public void seDaClicEnElBotonRegister() throws Throwable {
        try {
            click(driver,"id", BTN_REGISTER);
            stepPass(driver, "Se dió clic en el botón Register");
            generateWord.sendText("Se dió clic en el botón Register");
            generateWord.addImageToWord(driver);
        }
        catch (Exception e){
            ExcelReader.writeCellValue(EXCEL_WEB, CREAR_CUENTA, 1, 19, "FAIL");
            stepFail(driver,"El tiempo de espera ha excedido " + e.getMessage());
            generateWord.sendText("El tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Then("^Se registra la cuenta$")
    public void seRegistraLaCuenta() throws Throwable {
        try {
            if (isDisplayed(driver,"xpath", LBL_MY_ACCOUNT)){
                stepPass(driver,"Se registró correctamente la cuenta");
                generateWord.sendText("Se registró correctamente la cuenta");
                generateWord.addImageToWord(driver);
            }
        }
        catch (Exception e){
            ExcelReader.writeCellValue(EXCEL_WEB, CREAR_CUENTA, 1, 19, "FAIL");
            stepFail(driver,"El tiempo de espera ha excedido " + e.getMessage());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    private void limpiarCampos() throws Throwable {
        clear(driver,"id", TXT_FIRST_NAME);
        clear(driver,"id", TXT_LAST_NAME);
        clear(driver,"id", TXT_PASSWORD1);
        //clear(driver,"id", SELECT_DBIRTH);
        //clear(driver,"id", SELECT_DBIRTH);
        //clear(driver,"id", SELECT_YBIRTH);
        clear(driver,"id", TXT_CITY);
        //clear(driver,"id", SELECT_STATE);
        //clear(driver,"id", SELECT_COUNTRY);
        clear(driver,"id", TXT_MOBILE_PHONE);
        clear(driver,"id", TXT_REFERENCE_ADDRESS);
    }

}
