Feature: Crear Cuenta

@StoreOnline-VerificarCorreo
Scenario Outline: Verificar Correo

  Given Ingresar la URL de la pagina Store "<caso_prueba>"
  And Hacer clic en Sign In debe mostrar pagina de authenticacion
  When Se ingresa un correo electronico "<caso_prueba>"
  And Se da clic en el boton Create an Account
  Then Muestra pagina de personal information

  Examples:
    |caso_prueba|
    |          1|

@StoreOnline-CrearCuenta
Scenario Outline: Crear Cuenta

  Given Completar datos personales "<caso_prueba>"
  And Se da clic en el boton register
  Then Se registra la cuenta

  Examples:
    | caso_prueba |
    |           1 |


