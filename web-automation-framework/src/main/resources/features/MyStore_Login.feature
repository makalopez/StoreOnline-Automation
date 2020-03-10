
Feature: Store Online

  @StoreOnline_Login
  Scenario Outline: Login Store Online

    Given Ingresar a la URL de la pagina Store "<caso_prueba>"
    And Hacer clic on Sign In debe mostrar una página de login
    When Se ingresa el usuario "<caso_prueba>"
    And se ingresa la contraseña "<caso_prueba>"
    And Se da clic en el boton Sing in
    Then Se valida el logueo correctamente

    Examples:
      | caso_prueba |
      |           1 |
