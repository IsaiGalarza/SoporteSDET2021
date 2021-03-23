Feature: Como Administrador deberia ingresar a la plataforma de RRHH Orange con mi usuario y contraseña
  para gestionar mediante un panel usuarios, trabajo, datos de la empresa, nacionalidades y configuraciones propias de
  la plataforma.

  Scenario: Verificar acceso a la opcion Admin
    Given Cuando este en la aplicacion OrangeHRP
    When Inicie sesion en la aplicacion
    And Haga clic en el menu Admin
    Then la pagina del panel esta disponible
