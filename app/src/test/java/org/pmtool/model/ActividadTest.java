package org.pmtool.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import java.time.LocalDate;

public class ActividadTest {
    private Actividad actividad;

    @BeforeEach
    void setUp() {
        actividad = new Actividad("1.1", "Actividad Test", 40);
    }

    @Test
    void testCreacionActividad() {
        Assertions.assertNotNull(actividad);
        Assertions.assertEquals("1.1", actividad.getNumeroEDT());
        Assertions.assertEquals("Actividad Test", actividad.getNombre());
        Assertions.assertEquals(40, actividad.getTotalHorasEstimadas());
        Assertions.assertTrue(actividad.isPlanificada());
    }

    @Test
    void testPlanificarFechas() {
        LocalDate inicio = LocalDate.of(2024, 1, 1);
        LocalDate fin = LocalDate.of(2024, 12, 31);
        
        actividad.planificarFechas(inicio, fin);
        
        Assertions.assertEquals(inicio, actividad.getFechaInicioPlanificada());
        Assertions.assertEquals(fin, actividad.getFechaFinPlanificada());
    }

    @Test
    void testPlanificarFechasInvertidas() {
        LocalDate inicio = LocalDate.of(2024, 12, 31);
        LocalDate fin = LocalDate.of(2024, 1, 1);
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            actividad.planificarFechas(inicio, fin);
        });
    }

    @Test
    void testAgregarSubactividad() {
        Actividad subactividad = new Actividad("1.1.1", "Subactividad", 20);
        actividad.agregarSubactividad(subactividad);
        
        Assertions.assertEquals(1, actividad.getSubactividades().size());
        Assertions.assertEquals("1.1.1", subactividad.getNumeroEDT());
    }

    @Test
    void testActivarActividad() {
        actividad.activar();
        
        Assertions.assertTrue(actividad.isEnEjecucion());
        Assertions.assertNotNull(actividad.getFechaInicioReal());
        Assertions.assertTrue(actividad.isEnEjecucion());
    }

    @Test
    void testDesactivarActividad() {
        actividad.activar();
        actividad.desactivar();
        
        Assertions.assertTrue(actividad.isCompletada());
        Assertions.assertNotNull(actividad.getFechaFinReal());
        Assertions.assertTrue(actividad.isCompletada());
    }

    @Test
    void testActivarActividadCompletada() {
        actividad.activar();
        actividad.desactivar();
        
        Assertions.assertThrows(IllegalStateException.class, () -> {
            actividad.activar();
        });
    }

    @Test
    void testDesactivarActividadNoEnEjecucion() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            actividad.desactivar();
        });
    }
} 
