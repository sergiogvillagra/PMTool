package org.pmtool.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class PlanificarActividadesSteps {
    
    @Given("existe un proyecto en estado {string} con nombre {string}")
    public void existeUnProyectoEnEstadoConNombre(String estado, String nombre) {
        // Implementación pendiente
    }
    
    @When("se crea una actividad con código {string} y nombre {string}")
    public void seCreaUnaActividadConCodigoYNombre(String codigo, String nombre) {
        // Implementación pendiente
    }
    
    @Then("la actividad se agrega al proyecto")
    public void laActividadSeAgregaAlProyecto() {
        // Implementación pendiente
    }
    
    @And("la actividad tiene un código único {string}")
    public void laActividadTieneUnCodigoUnico(String codigo) {
        // Implementación pendiente
    }
    
    @When("se intenta crear una actividad con código {string} y sin nombre")
    public void seIntentaCrearUnaActividadConCodigoYSinNombre(String codigo) {
        // Implementación pendiente
    }
    
    @Then("se muestra un mensaje de error indicando que el nombre de la actividad es obligatorio")
    public void seMuestraUnMensajeDeErrorIndicandoQueElNombreDeLaActividadEsObligatorio() {
        // Implementación pendiente
    }
    
    @When("se intenta agregar una actividad al proyecto")
    public void seIntentaAgregarUnaActividadAlProyecto() {
        // Implementación pendiente
    }
    
    @Then("se muestra un mensaje de error indicando que no se pueden agregar actividades a un proyecto finalizado")
    public void seMuestraUnMensajeDeErrorIndicandoQueNoSePuedenAgregarActividades() {
        // Implementación pendiente
    }

    @When("el Gerente de Proyecto intenta definir una nueva actividad")
    public void elGerenteDeProyectoIntentaDefinirUnaNuevaActividad() {
        // Implementación pendiente
    }

    @Then("se informa un mensaje indicando que no se pueden agregar actividades a proyectos finalizados")
    public void seInformaUnMensajeIndicandoQueNoSePuedenAgregarActividadesAProyectosFinalizados() {
        // Implementación pendiente
    }

    @When("el Gerente de Proyecto intenta definir una nueva actividad sin nombre")
    public void elGerenteDeProyectoIntentaDefinirUnaActividadSinNombre() {
        // Implementación pendiente
    }

    @Then("se informa un mensaje indicando que el nombre es obligatorio")
    public void seInformaUnMensajeIndicandoQueElNombreEsObligatorio() {
        // Implementación pendiente
    }

    @And("no se registra la actividad al proyecto")
    public void noSeRegistraLaActividadAlProyecto() {
        // Implementación pendiente
    }

    @When("el Gerente de Proyecto define una nueva actividad con nombre y fechas planificadas")
    public void elGerenteDeProyectoDefineUnaNuevaActividadConNombreYFechasPlanificadas() {
        // Implementación pendiente
    }
    
    @Then("se asigna un código único a la actividad")
    public void seAsisgnaUcCodigoUnicoALaActividad() {
        // Implementación pendiente
    }

    @And("la actividad se asocia al proyecto")
    public void laActividadSeAsociaAlProyecto() {
        // Implementación pendiente
    }

    @And("su estado inicial es {string}")
    public void suEstadoInicialEs(String estado) {
        // Implementación pendiente
    }
    
} 
