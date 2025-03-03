Feature: Cambio de estado del proyecto
  # Como Gerente de Proyecto
  # Quiero cambiar el estado del proyecto según su progreso
  # Para reflejar su evolución

  Scenario: Cambio de estado de "Planificado" a "En curso"
    Given existe un proyecto en estado "PLANIFICADO"
    When el Gerente de Proyecto suministra una fecha real de inicio y una fecha real de fin
    Then el estado del proyecto cambia a "EN_CURSO"

  Scenario: Intento de marcar como finalizado sin fecha real de finalización
    Given existe un proyecto en estado "EN_CURSO"
    When el Gerente de Proyecto intenta modificar el estado del proyecto a "FINALIZADO" sin proveer la fecha real de finalización
    Then se informa un mensaje indicando que falta la fecha de finalización
    And el proyecto mantiene el estado en "EN_CURSO"

  Scenario: El proyecto se finaliza cuando todas las actividades están completadas
    Given existe un proyecto en estado "EN_CURSO"
    And todas las actividades del proyecto están en estado "COMPLETADA"
    When el Gerente de Proyecto solicita finalizar el proyecto
    Then el estado del proyecto cambia a "FINALIZADO"
    And se registra la fecha real de finalización del proyecto