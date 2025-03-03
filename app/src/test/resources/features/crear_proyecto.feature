Feature: Inclusión de un nuevo proyecto en el portafolio
  # Como Gerente de Portafolio
  # Quiero incluir un nuevo proyecto en el portafolio
  # Para cumplir con los objetivos de la organización

  Scenario: Creación de un proyecto dentro del portafolio
    Given existe un portafolio de proyectos
    When el Gerente de Portafolio solicita agregar un nuevo proyecto al portafolio
    Then se crea un nuevo proyecto con un código único, un nombre, el total de horas estimadas, el presupuesto y en estado "PLANIFICADO"