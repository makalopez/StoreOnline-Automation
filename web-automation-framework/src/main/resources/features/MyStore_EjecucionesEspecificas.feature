Feature: Ejecucion de Escenarios Especificos

@StoreOnline-CrearCuentaCompleta
  Scenario Outline: VerificarCorreo-CrearCuenta

    Given Ingresar la URL de la pagina Store "<caso_prueba>"
    And Hacer clic en Sign In debe mostrar pagina de authenticacion
    When Se ingresa un correo electronico "<caso_prueba>"
    And Se da clic en el boton Create an Account
    Then Muestra pagina de personal information
    Given Completar datos personales "<caso_prueba>"
    And Se da clic en el boton register
    Then Se registra la cuenta

    Examples:
      | caso_prueba |
      |           1 |

  @StoreOnline-RealizarBusqueda
  Scenario Outline: Realizar Busqueda

    Given Ingresar la URL de la pagina Store "<caso_prueba>"
    Given Se ingresa el producto a buscar "<caso_prueba>"
    And Se da clic en la lupa
    Then Lista los productos de la busqueda

    Examples:
      | caso_prueba |
      |           1 |

  @StoreOnline-CrearCuentaCompleta-RealizaBusqueda
  Scenario Outline: VerificarCorreo-CrearCuenta-RealizaBusqueda

    Given Ingresar la URL de la pagina Store "<caso_prueba>"
    And Hacer clic en Sign In debe mostrar pagina de authenticacion
    When Se ingresa un correo electronico "<caso_prueba>"
    And Se da clic en el boton Create an Account
    Then Muestra pagina de personal information
    Given Completar datos personales "<caso_prueba>"
    And Se da clic en el boton register
    Then Se registra la cuenta
    Given Se ingresa el producto a buscar "<caso_prueba>"
    And Se da clic en la lupa
    Then Lista los productos de la busqueda
    Given Se da clic en el boton Add to cart


    Examples:
      | caso_prueba |
      |           1 |

  @StoreOnline-RealizarBusqueda-SeleccionarProducto
  Scenario Outline: Realizar Busqueda

    Given Ingresar la URL de la pagina Store "<caso_prueba>"
    And Hacer clic on Sign In debe mostrar una página de login
    When Se ingresa el usuario "<caso_prueba>"
    And se ingresa la contraseña "<caso_prueba>"
    And Se da clic en el boton Sing in
    Given Se ingresa el producto a buscar "<caso_prueba>"
    And Se da clic en la lupa
    Then Lista los productos de la busqueda
    Given Se da clic en el boton Add to cart
    When Muestra pagina detalle producto se da clic en el boton proceed to checkout
    And Muestra pagina shopping-cart summary se da clic en el boton proceed to checkout
    And Muestra pagina de direccion personal se da clic en el boton proceed to checkout
    And Muestra pagina de shipping se selecciona terminos y condiciones se da clic en el boton proceed to checkout
    And Muestra pagina de metodo de pago se Selecciona metodo de pago
    And Muestra pagina confirmar order Clic en I confirm my order
    Then Muestra pagina de confirmacion de compra

    Examples:
      | caso_prueba |
      |           1 |