Feature: Como Administrador deberia ingresar a la plataforma de RRHH Orange con mi usuario y contrasena
  y tener acceso a la opcion Directory y poder realizar busquedas con diferentes criterios.

  Background: 
    Given El usuario ha iniciado sesion en la aplicacion Orange
    When Cuando hago clic en el enlace Directory

  @SmokeTest @RegressionTest
  Scenario: Validar acceso a la opcion Directory
    Then Se despliega la seccion Search Directory

  @SmokeTest @RegressionTest
  Scenario: Buscar por nombre
    And Ingreso nombre
    And Hago clic en el boton Search
    Then Se despliega los usuarios que cumplan el criterio de busqueda

  @SmokeTest @RegressionTest
  Scenario: Buscar por Job Title
    And Selecciono un elemento de la lista Job Title
    And Hago clic en el boton Search
    Then Se despliega los usuarios que cumplan el criterio de busqueda

  @SmokeTest @RegressionTest
  Scenario: Buscar por Location
    And Selecciono un elemento de la lista Location
    And Hago clic en el boton Search
    Then Se despliega los usuarios que cumplan el criterio de busqueda

