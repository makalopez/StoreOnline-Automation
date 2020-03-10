package com.tsoft.bot.frontend.steps.myStore;

import com.tsoft.bot.frontend.BaseClass;
import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.utility.ExcelReader;
import com.tsoft.bot.frontend.utility.GenerateWord;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.tsoft.bot.frontend.pageobject.myStore.PageObject_MyStore.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Steps_CarritoCompra extends BaseClass {

    private WebDriver driver;
    private static final String EXCEL_WEB = "excel/StoreOnline.xlsx";
    private static final String BUSQUEDA = "Busqueda";
    private static final String PRODUCTO_BUSQUEDA = "ProductoBusqueda";
    GenerateWord generateWord = new GenerateWord();

    public Steps_CarritoCompra(){
        this.driver = Hook.getDriver();
    }
    private List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(EXCEL_WEB, BUSQUEDA);
    }

    @Given("^Se ingresa el producto a buscar \"([^\"]*)\"$")
    public void seIngresaElProductoABuscar(String caso_prueba) throws Throwable {
        try {
            int myStore = Integer.parseInt(caso_prueba) - 1;
            String Busqueda = getData().get(myStore).get(PRODUCTO_BUSQUEDA);
            clear(driver,"id", TXT_BUSQUEDA);
            sendKeyValue(driver,"id", TXT_BUSQUEDA, Busqueda);
            stepPass(driver, "Se ha ingresado el producto a buscar");
            generateWord.sendText("Se ha ingresado el producto a buscar");
            generateWord.addImageToWord(driver);
        }
        catch (Exception e){
            ExcelReader.writeCellValue(EXCEL_WEB, BUSQUEDA, 1, 19, "FAIL");
            stepFail(driver,"El tiempo de espera ha excedido " + e.getMessage());
            generateWord.sendText("El tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @And("^Se da clic en la lupa$")
    public void seDaClicEnLaLupa() throws Throwable {
        try {
            click(driver,"name", BTN_BUSQUEDA);
            stepPass(driver, "Se hizo clic en la lupa");
            generateWord.sendText("Se hizo clic en la lupa");
            generateWord.addImageToWord(driver);
        }
        catch (Exception e){
            ExcelReader.writeCellValue(EXCEL_WEB, BUSQUEDA, 1, 19, "FAIL");
            stepFail(driver,"El tiempo de espera ha excedido " + e.getMessage());
            generateWord.sendText("El tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @Then("^Lista los productos de la busqueda$")
    public void listaLosProductosDeLaBusqueda() throws Throwable {
        try {
            if (isDisplayed(driver, "xpath", LBL_BUSQUEDA)){
                stepPass(driver, "Se ha realizado la búsqueda del texto ingresado");
                generateWord.sendText("Se ha realizado la búsqueda del texto ingresado");
                generateWord.addImageToWord(driver);
            }
        }
        catch (Exception e){
            ExcelReader.writeCellValue(EXCEL_WEB, BUSQUEDA, 1, 19, "FAIL");
            stepFail(driver,"El tiempo de espera ha excedido " + e.getMessage());
            generateWord.sendText("El tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @Given("^Se da clic en el boton Add to cart$")
    public void seDaClicEnElBotonAddToCart() throws Throwable {
        try {
//            Robot robot = new Robot();
//            robot.keyPress(KeyEvent.VK_PAGE_DOWN);
//            Screen screen = new Screen();
//            screen.wait(IMG_SELECCIONAR_PRODUCTO, 10000);
//            screen.mouseMove(IMG_SELECCIONAR_PRODUCTO);

            Actions act = new Actions(driver);
            WebElement findElement = driver.findElement(IMG_SELECCIONAR_PRODUCTO);
            act.moveToElement(findElement).build().perform();
            findElement.click();
            click(driver,"name", BTN_ADD_TO_CART);
            stepPass(driver,"Se seleccionó producto haciendo clic en Add to cart");
            generateWord.sendText("Se seleccionó producto haciendo clic en Add to cart");
            generateWord.addImageToWord(driver);
        }
        catch (Exception e){
            ExcelReader.writeCellValue(EXCEL_WEB, BUSQUEDA,1,19, "FAIL");
            stepFail(driver,"El tiempo de espera ha excedido " + e.getMessage());
            generateWord.sendText("El tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @When("^Muestra pagina detalle producto se da clic en el boton proceed to checkout$")
    public void muestraPaginaDetalleProductoSeDaClicEnElBotonProceddToCheckouts() throws Throwable {
        try {
            String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
            String subWindowHandler = null;

            Set<String> handles = driver.getWindowHandles(); // get all window handles
            Iterator<String> iterator = handles.iterator();
            while (iterator.hasNext()){
                subWindowHandler = iterator.next();
            }
            driver.switchTo().window(subWindowHandler); // switch to popup window
            //driver.switchTo().window(parentWindowHandler);

            if (isDisplayed(driver,"xpath", LBL_DETALLE_PRODUCTO)){
                click(driver,"xpath", BTN_CHECKOUT_FIRST);
                stepPass(driver, "En la pagina Detalle producto se da clic en el botón Add to cart");
                generateWord.sendText("En la pagina Detalle producto se da clic en el botón Add to cart");
                generateWord.addImageToWord(driver);
            }
        }
        catch (Exception e){
            ExcelReader.writeCellValue(EXCEL_WEB, BUSQUEDA,1,19, "FAIL");
            stepFail(driver,"El tiempo de espera ha excedido " + e.getMessage());
            generateWord.sendText("El tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @And("^Muestra pagina shopping-cart summary se da clic en el boton proceed to checkout$")
    public void muestraPaginaShoppingCartSummarySeDaClicEnElBotonProceedToCheckout() throws Throwable {
        try {
            if (isDisplayed(driver,"xpath", LBL_SHOPPING_CART)){
                click(driver,"xpath", BTN_CHECKOUT_SECOND);
                stepPass(driver, "En la pagina Shopping-cart summary se da clic en el botón Proceed to Checkout");
                generateWord.sendText("En la pagina Shopping-cart summary se da clic en el botón Proceed to Checkout");
                generateWord.addImageToWord(driver);
            }
        }
        catch (Exception e){
            ExcelReader.writeCellValue(EXCEL_WEB, BUSQUEDA,1,19, "FAIL");
            stepFail(driver,"El tiempo de espera ha excedido " + e.getMessage());
            generateWord.sendText("El tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @And("^Muestra pagina de direccion personal se da clic en el boton proceed to checkout$")
    public void muestraPaginaDeDireccionPersonalSeDaClicEnElBotonProceedToCheckout() throws Throwable {
        try {
            if (isDisplayed(driver,"xpath", LBL_ADDRESS)){
                click(driver,"name", BTN_CHECKOUT_THIRD);
                stepPass(driver, "En la pagina Address se da clic en el botón Proceed to Checkout");
                generateWord.sendText("En la pagina Address se da clic en el botón Proceed to Checkout");
                generateWord.addImageToWord(driver);
            }
        }
        catch (Exception e){
            ExcelReader.writeCellValue(EXCEL_WEB, BUSQUEDA,1,19, "FAIL");
            stepFail(driver,"El tiempo de espera ha excedido " + e.getMessage());
            generateWord.sendText("El tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @And("^Muestra pagina de shipping se selecciona terminos y condiciones se da clic en el boton proceed to checkout$")
    public void muestraPaginaDeShippingSeSeleccionaTerminosYCondicionesSeDaClicEnElBotonProceedToCheckout() throws Throwable {
        try {
            if (isDisplayed(driver,"xpath", LBL_SHIPPING)){
                click(driver,"id", CHBOX_TERMINOS);
                click(driver,"name", BTN_CHECKOUT_FOURTH);
                stepPass(driver, "En la pagina Shipping se selecciona los terminos y condiciones y se da clic en el botón Proceed to Checkout");
                generateWord.sendText("En la pagina Shipping se selecciona los terminos y condiciones y se da clic en el botón Proceed to Checkout");
                generateWord.addImageToWord(driver);
            }
        }
        catch (Exception e){
            ExcelReader.writeCellValue(EXCEL_WEB, BUSQUEDA,1,19, "FAIL");
            stepFail(driver,"El tiempo de espera ha excedido " + e.getMessage());
            generateWord.sendText("El tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @And("^Muestra pagina de metodo de pago se Selecciona metodo de pago$")
    public void muestraPaginaDeMetodoDePago() throws Throwable {
        try {
            if (isDisplayed(driver,"xpath", LBL_PAYMENT_METHOD)){
                click(driver,"xpath", DIV_PAYMENT_METHOD);
                stepPass(driver, "En la pagina Metodo de Pago se selecciona el método de pago");
                generateWord.sendText("En la pagina Metodo de Pago se selecciona el método de pago");
                generateWord.addImageToWord(driver);
            }
        }
        catch (Exception e){
            ExcelReader.writeCellValue(EXCEL_WEB, BUSQUEDA,1,19, "FAIL");
            stepFail(driver,"El tiempo de espera ha excedido " + e.getMessage());
            generateWord.sendText("El tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @And("^Muestra pagina confirmar order Clic en I confirm my order$")
    public void muestraPaginaConfirmarOrderClicEnIConfirmMyOrder() throws Throwable {
        try {
            if (isDisplayed(driver,"xpath", LBL_ORDER_SUMMARY)){
                click(driver,"xpath", BTN_CONFIRM_ORDER);
                stepPass(driver, "En la pagina Confirmar Orden se da clic al botón Confirm my Order");
                generateWord.sendText("En la pagina Confirmar Orden se da clic al botón Confirm my Order");
                generateWord.addImageToWord(driver);
            }

        }
        catch (Exception e){
            ExcelReader.writeCellValue(EXCEL_WEB, BUSQUEDA,1,19, "FAIL");
            stepFail(driver,"El tiempo de espera ha excedido " + e.getMessage());
            generateWord.sendText("El tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @Then("^Muestra pagina de confirmacion de compra$")
    public void muestraPaginaDeConfirmacionDeCompra() throws Throwable {
        try {
            if (isDisplayed(driver,"xpath", LBL_ORDER_CONFIRMATION)){
                stepPass(driver, "Se ha confirmado la compra exitosamente");
                generateWord.sendText("Se ha confirmado la compra exitosamente");
                generateWord.addImageToWord(driver);
            }
        }
        catch (Exception e){
            ExcelReader.writeCellValue(EXCEL_WEB, BUSQUEDA,1,19, "FAIL");
            stepFail(driver,"El tiempo de espera ha excedido " + e.getMessage());
            generateWord.sendText("El tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }
}
