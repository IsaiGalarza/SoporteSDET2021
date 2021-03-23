Feature: Como Administrador deberia ingresar a la plataforma de RRHH Orange con mi usuario y contraseña
  para gestionar Job de la opcion Admin.

  Background: 
    Given He iniciado sesion en la aplicacion Orange

  Scenario: Verificar acceso a la opcion Job dentro de Admin
    When Cuando hago clic en el enlace Administrador
    And Haga clic en Job
    And Validar texto
    Then Titulo del Job
