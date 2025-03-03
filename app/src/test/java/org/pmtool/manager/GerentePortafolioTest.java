package org.pmtool.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.pmtool.model.Proyecto;
import org.pmtool.model.Proyecto.EstadoProyecto;

public class GerentePortafolioTest {
    private GerentePortafolio gerentePortafolio;

    @BeforeEach
    void setUp() {
        gerentePortafolio = new GerentePortafolio();
    }

    @Test
    void testCrearProyecto() {
        String nombreProyecto = "Nuevo Proyecto";
        int horasEstimadas = 150;
        double presupuesto = 60000.0;
        
        Proyecto proyecto = gerentePortafolio.crearProyecto(nombreProyecto, horasEstimadas, presupuesto);
        
        Assertions.assertNotNull(proyecto);
        Assertions.assertEquals(nombreProyecto, proyecto.getNombre());
        Assertions.assertEquals(EstadoProyecto.PLANIFICADO, proyecto.getEstado());
    }
} 
