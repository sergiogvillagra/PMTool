Feature: Planificación de actividades de un proyecto
  # Como Gerente de Proyecto
  # Quiero planificar las actividades de un proyecto
  # Para poder cumplir con sus objetivos

  Scenario: Creación de una actividad con código único
    Given existe un proyecto en estado "PLANIFICADO"
    When el Gerente de Proyecto define una nueva actividad con nombre y fechas planificadas
    Then se asigna un código único a la actividad
    And la actividad se asocia al proyecto
    And su estado inicial es "PLANIFICADA"

  Scenario: Intento de crear una actividad sin nombre
    Given existe un proyecto en estado "PLANIFICADO"
    When el Gerente de Proyecto intenta definir una nueva actividad sin nombre
    Then se informa un mensaje indicando que el nombre es obligatorio
    And no se registra la actividad al proyecto

  Scenario: Intento de agregar actividades a un proyecto finalizado
    Given existe un proyecto en estado "FINALIZADO"
    When el Gerente de Proyecto intenta definir una nueva actividad
    Then se informa un mensaje indicando que no se pueden agregar actividades a proyectos finalizados