package org.pmtool.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.pmtool.manager.GerentePortafolio;
import org.pmtool.model.Proyecto;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CrearProyectoSteps {
    
    private GerentePortafolio gerentePortafolio;
    private Proyecto proyecto;
    
    @Given("existe un portafolio de proyectos")
    public void existeUnPortafolioDeProyectos() {
        gerentePortafolio = new GerentePortafolio();
    }
    
    @When("el Gerente de Portafolio solicita agregar un nuevo proyecto al portafolio")
    public void elGerenteDePortafolioSolicitaAgregarUnNuevoProyecto() {
        proyecto = gerentePortafolio.crearProyecto("Proyecto Test", 100, 50000.0);
    }
    
    @Then("se crea un nuevo proyecto con un código único, un nombre, el total de horas estimadas, el presupuesto " +
            "y en estado {string}")
    public void seCreaUnNuevoProyectoConCodigoUnico(String estado) {
        assertNotNull(proyecto);
        assertTrue(proyecto.getNumero() > 1);
        assertEquals("Proyecto Test", proyecto.getNombre());
        assertTrue(proyecto.isPlanificado());
        assertTrue(proyecto.getTotalHorasEstimadas() > 0);
        assertTrue(proyecto.getPresupuesto() > 0);
    }
} 
