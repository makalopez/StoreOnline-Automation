package com.tsoft.bot.frontend.pageobject.myStore;

import com.sun.org.apache.bcel.internal.generic.Select;
import com.tsoft.bot.frontend.helpers.Hook;
import org.openqa.selenium.By;

import org.sikuli.script.Pattern;

import javax.swing.plaf.PanelUI;

public class PageObject_MyStore extends Hook {

    //CrearCuenta
    /*public static By LNK_SINGIN = By.linkText("Sign in");
    public static By TXT_EMAIL = By.id("email_create");
    public static By BTN_CREATE_ACOUNT = By.id("SubmitCreate");
    public static By LBL_CREATE_ACCOUNT = By.xpath("//h1[text()='Create an account']");*/

    //Login
    /*public static By LBL_VALIDAR1 = By.className("page-heading");
    public static By TXT_USUARIO = By.id("email");
    public static By TXT_PASSWORD = By.id("passwd");
    public static By BTN_SINGIN = By.id("SubmitLogin");*/

    //Verificar Correo
    public static String LNK_SINGIN = "Sign in";
    public static String TXT_EMAIL = "email_create";
    public static String BTN_CREATE_ACOUNT = "SubmitCreate";
    public static String LBL_CREATE_ACCOUNT = "//h1[text()='Create an account']";

    //Completar Informacion
    public static String RADIO_TITLE = "id_gender2";
    public static String TXT_FIRST_NAME = "customer_firstname";
    public static String TXT_LAST_NAME = "customer_lastname";
    public static String TXT_PASSWORD1 = "passwd";
    public static String SELECT_DBIRTH = "days";
    public static String SELECT_MBIRTH = "months";
    public static String SELECT_YBIRTH = "years";
    public static String TXT_ADDRESS = "address1";
    public static String TXT_CITY = "city";
    public static String SELECT_STATE = "id_state";
    public static String TXT_ZIP_CODE = "postcode";
    public static String SELECT_COUNTRY = "id_country";
    public static String TXT_MOBILE_PHONE = "phone_mobile";
    public static String TXT_REFERENCE_ADDRESS = "alias";
    public static String BTN_REGISTER = "submitAccount";
    public static String LBL_MY_ACCOUNT = "//h1[text()='My account']";

    //Login
    public static String TXT_USUARIO = "email";
    public static String TXT_PASSWORD2 = "passwd";
    public static String BTN_SINGIN = "SubmitLogin";

    //Busqueda
    public static String TXT_BUSQUEDA = "search_query_top";
    public static String BTN_BUSQUEDA = "submit_search";
    public static String LBL_BUSQUEDA = "//span[contains(text(), 'results have been found.')]";

    //Agregar Producto a Carro y realizar pago
    public static By IMG_SELECCIONAR_PRODUCTO = By.linkText("Printed Chiffon Dress");
    //public static final Pattern IMG_SELECCIONAR_PRODUCTO = new Pattern("/src/main/resources/sikuli-img/producto1.png");
    public static String BTN_ADD_TO_CART = "Submit";
    public static String LBL_DETALLE_PRODUCTO = "/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[1]/h2";
    public static String BTN_CHECKOUT_FIRST = "/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span/i";
    public static String LBL_SHOPPING_CART = "//h1[contains(text(), 'Shopping-cart summary')]";
    public static String BTN_CHECKOUT_SECOND = "/html/body/div/div[2]/div/div[3]/div/p[2]/a[1]";
    public static String LBL_ADDRESS = "/html/body/div/div[2]/div/div[3]/div/form/div/div[1]/div[1]/div";
    public static String BTN_CHECKOUT_THIRD = "processAddress";
    public static String LBL_SHIPPING = "//p[contains(text(), 'Choose a shipping option for')]";
    public static String CHBOX_TERMINOS = "uniform-cgv";
    public static String BTN_CHECKOUT_FOURTH = "processCarrier";
    public static String LBL_PAYMENT_METHOD = "//h1[text()='Please choose your payment method']";
    public static String DIV_PAYMENT_METHOD = "/html/body/div/div[2]/div/div[3]/div/div/div[3]/div[1]/div/p/a";
    public static String LBL_ORDER_SUMMARY = "/html/body/div/div[2]/div/div[3]/div/h1";
    public static String BTN_CONFIRM_ORDER = "/html/body/div/div[2]/div/div[3]/div/form/p/button";
    public static String LBL_ORDER_CONFIRMATION = "//h1[text()='Order confirmation']";


}
