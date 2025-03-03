package org.pmtool.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FinalizarActividadSteps {
    
    @Given("existe una actividad en estado {string}")
    public void existeUnaActividadEnEstado(String estado) {
        // Implementación pendiente
    }
    
    @When("el Gerente de Proyecto informa una fecha real de finalización")
    public void elGerenteDeProyectoInformaUnaFechaRealDeFinalizacion() {
        // Implementación pendiente
    }
    
    @Then("el estado de la actividad cambia a {string}")
    public void elEstadoDeLaActividadCambiaA(String estado) {
        // Implementación pendiente
    }
    
    @When("el Gerente de Proyecto intenta modificar el estado a {string} sin proveer la fecha real de finalización")
    public void elGerenteDeProyectoIntentaModificarElEstadoSinProveerLaFechaRealDeFinalizacion(String estado) {
        // Implementación pendiente
    }
    
    @Then("se informa un mensaje indicando que falta la fecha real de finalización")
    public void seInformaUnMensajeIndicandoQueFaltaLaFechaRealDeFinalizacion() {
        // Implementación pendiente
    }
    
    @And("la actividad mantiene su estado en {string}")
    public void laActividadMantieneSuEstadoEn(String estado) {
        // Implementación pendiente
    }

} 
