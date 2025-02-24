package org.pmtool.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import java.time.LocalDate;

public class ProyectoTest {
    private Proyecto proyecto;

    @BeforeEach
    void setUp() {
        proyecto = new Proyecto("Proyecto Test", 100, 50000.0);
    }

    @Test
    void testCreacionProyecto() {
        Assertions.assertNotNull(proyecto);
        Assertions.assertEquals("Proyecto Test", proyecto.toString().split(",")[1].split("'")[1]);
        Assertions.assertEquals("Planificado", proyecto.toString().split(",")[2].split("'")[1]);
    }

    @Test
    void testPlanificarFechas() {
        LocalDate inicio = LocalDate.of(2024, 1, 1);
        LocalDate fin = LocalDate.of(2024, 12, 31);
        
        proyecto.planificarFechas(inicio, fin);
        // La planificación no debería lanzar excepción
        
        // Verificar que lanza excepción cuando las fechas están invertidas
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            proyecto.planificarFechas(fin, inicio);
        });
    }

    @Test
    void testAgregarActividad() {
        Proyecto.Actividad actividad = proyecto.new Actividad("1.1", "Actividad Test", 40);
        proyecto.agregarActividad(actividad);
        
        Assertions.assertEquals(1, proyecto.getActividades().size());
        Assertions.assertTrue(proyecto.getActividades().contains(actividad));
    }

    @Test
    void testActividadJerarquia() {
        Proyecto.Actividad actividad = proyecto.new Actividad("1", "Actividad Principal", 40);
        Proyecto.Actividad subactividad = proyecto.new Actividad("1.1", "Subactividad", 20);
        
        actividad.agregarSubactividad(subactividad);
        
        Assertions.assertEquals(1, actividad.getSubactividades().size());
        Assertions.assertEquals("1.1", subactividad.getNumeroEDT());
    }
} 
