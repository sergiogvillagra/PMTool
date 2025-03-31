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
        Assertions.assertEquals("Proyecto Test", proyecto.getNombre());
        Assertions.assertTrue(proyecto.isPlanificado());
        Assertions.assertTrue(proyecto.getTotalHorasEstimadas() > 0);
        Assertions.assertTrue(proyecto.getPresupuesto() > 0);
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
        Actividad actividad = new Actividad("1.1", "Actividad Test", 40);
        proyecto.agregarActividad(actividad);
        
        Assertions.assertEquals(1, proyecto.getActividades().size());
        Assertions.assertTrue(proyecto.getActividades().contains(actividad));
    }

    @Test
    void testActividadJerarquia() {
        Actividad actividad = new Actividad("1", "Actividad Principal", 40);
        Actividad subactividad = new Actividad("1.1", "Subactividad", 20);
        
        actividad.agregarSubactividad(subactividad);
        
        Assertions.assertEquals(1, actividad.getSubactividades().size());
        Assertions.assertEquals("1.1", subactividad.getNumeroEDT());
    }

    @Test
    void testFinalizarProyecto() {
        Actividad actividad = new Actividad("1.1", "Actividad Test", 40);
        proyecto.agregarActividad(actividad);
        
        // Activar y desactivar la actividad
        actividad.activar();
        actividad.desactivar();
        
        // Finalizar el proyecto
        proyecto.finalizar(LocalDate.now());
        
        Assertions.assertEquals(Proyecto.EstadoProyecto.FINALIZADO, proyecto.getEstado());
    }

    @Test
    void testFinalizarProyectoConActividadIncompleta() {
        Actividad actividad = new Actividad("1.1", "Actividad Test", 40);
        proyecto.agregarActividad(actividad);
        
        // Intentar finalizar el proyecto sin completar la actividad
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            proyecto.finalizar(LocalDate.now());
        });
    }
} 
