Feature: Flujo de Compra

  @MyStore_Realizar_Busqueda
  Scenario Outline: Flujo de compra

    Given Se ingresa el producto a buscar "<caso_prueba>"
    And Se da clic en la lupa
    Then Lista los productos de la busqueda

    Examples:
      | caso_prueba |
      |           1 |

@MyStore_SeleccionarProducto
Scenario Outline: Seleccionar Producto
  Given Se da clic en el boton Add to cart
  When Muestra pagina detalle producto se da clic en el boton proceed to checkout
  And Muestra pagina shopping-cart summary se da clic en el boton proceed to checkout
  And Muestra pagina de direccion personal se da clic en el boton proceed to checkout
  And Muestra pagina de shipping se selecciona terminos y condiciones se da clic en el boton proceed to checkout
  And Muestra pagina de metodo de pago se Selecciona metodo de pago
  And Muestra pagina confirmar order Clic en I confirm my order
  Then Muestra pagina de confirmacion de compra

  Examples:
    |  |




