package org.pmtool.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.pmtool.manager.GerenteProyecto;
import org.pmtool.model.Proyecto;
import org.pmtool.model.Proyecto.Actividad;
import org.pmtool.model.Proyecto.Actividad.EstadoActividad;
import org.pmtool.model.Proyecto.EstadoProyecto;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CambiarEstadoProyectoSteps {

    private GerenteProyecto gerenteProyecto;
    private Proyecto proyecto;

    @Before
    public void setup() {
        gerenteProyecto = new GerenteProyecto();
        proyecto = new Proyecto("Proyecto test", 100, 50000.0);
    }

    @Given("existe un proyecto en estado {string}")
    public void existeUnProyectoEnEstado(String estado) {
        if (EstadoProyecto.EN_CURSO.equals(EstadoProyecto.valueOf(estado))) {
            proyecto.planificarFechas(LocalDate.now(), LocalDate.now().plusDays(365));
        }
    }

    @When("el Gerente de Proyecto suministra una fecha real de inicio y una fecha real de fin")
    public void elGerenteDeProyectoSuministraUnaFechaRealDeInicio() {
        gerenteProyecto.planificarProyecto(proyecto, LocalDate.now(), LocalDate.now().plusDays(365));
    }

    @Then("el estado del proyecto cambia a {string}")
    public void elEstadoDelProyectoCambiaA(String estado) {
        assertEquals(EstadoProyecto.valueOf(estado), proyecto.getEstado());
    }

    @When("el Gerente de Proyecto intenta modificar el estado del proyecto a {string} sin proveer " +
            "la fecha real de finalización")
    public void elGerenteDeProyectoIntentaModificarElEstadoSinProveerLaFechaRealDeFinalizacion(String nuevoEstado) {
        // Implementación pendiente
    }

    @Then("se informa un mensaje indicando que falta la fecha de finalización")
    public void seInformaUnMensajeIndicandoQueFaltaLaFechaDeFinalizacion() {
        // Implementación pendiente
    }

    @And("el proyecto mantiene el estado en {string}")
    public void elProyectoMantieneElEstadoEn(String estado) {
        assertEquals(EstadoProyecto.valueOf(estado), proyecto.getEstado());
    }

    @Given("todas las actividades del proyecto están en estado {string}")
    public void todasLasActividadesDeUnProyectoEstanEnEstado(String estado) {
        if (EstadoActividad.COMPLETADA.equals(EstadoActividad.valueOf(estado))) {
            for (Actividad actividad : proyecto.getActividades()) {
                if (!actividad.isCompletada() && !actividad.isEnEjecucion()) {
                    actividad.activar(); // Activar si no está en ejecución ni completada
                }
                if (actividad.isCompletada() || actividad.isEnEjecucion()) {
                    actividad.desactivar(); // Desactivar si ya está completada o en ejecución
                }
            }
        }
    }

    @When("el Gerente de Proyecto solicita finalizar el proyecto")
    public void elGerenteDeProyectoSolicitaFinalizarElProyecto() {
        gerenteProyecto.finalizarProyecto(proyecto, null);
    }

    @And("se registra la fecha real de finalización del proyecto")
    public void seRegistraLaFechaRealDeFinalizacionDelProyecto() {
        assertEquals(LocalDate.now(), proyecto.getFechaFinReal());
    }

}
