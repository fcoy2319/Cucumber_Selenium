@functional
Feature: Categoria Comics
  Como usuario quiero leer chistes de tester para reirme y pasar un buen rato

  @browser @fast
  Scenario: Ingresar a la categoría comics desde la pantalla home
    Given Usuario se encuentra en la página home de imalittletester
    When Hace click en el botón The Little Tester Comics
    Then Se debe redirigir a la pantalla comics

  @outline @slow
  Scenario Outline: Bebiendo
    Given Tengo <inicio> cervezas
    When  He tomado <cantidad> cervezas
    Then  Deberían quedar <resto> ceverzas

    @test1
    Examples:
      | inicio  | cantidad  | resto |
      | 10      | 5         | 5     |
      | 11      | 11        | 0     |

    @test2
    Examples:
      | inicio  | cantidad  | resto |
      | 15      | 5         | 10    |
      | 10      | 9         | 1     |

  @docsstring @slow
  Scenario: Docs strings
    Given Un blog llamado "Random" con el siguiente contenido
    """
    Teoria de la tierra en forma de rosquilla
    =================
    Este es el primer parrafo
    """
  @datatable
  Scenario: Data table
    Given Los siguientes usuarios existentes:
      | nombre | email           | twitter |
      | santi  | santi@gmail.com | @santi  |
      | orion  | ori@gmail.com   | @ori    |