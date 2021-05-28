Feature: Categoria Comics
  Como usuario quiero leer chistes de tester para reirme y pasar un buen rato

  Scenario: Ingresar a la categoría comics desde la pantalla home
    Given Usuario se encuentra en la página home de imalittletester
    When Hace click en el botón The Little Tester Comics
    Then Se debe redirigir a la pantalla comics