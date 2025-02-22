package org.pmtool.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.pmtool.model.Proyecto;

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
        
        assertNotNull(proyecto);
        assertEquals(nombreProyecto, proyecto.toString().split(",")[1].split("'")[1]);
        assertEquals("Planificado", proyecto.toString().split(",")[2].split("'")[1]);
    }
} 