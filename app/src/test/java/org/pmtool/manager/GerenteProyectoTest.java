package org.pmtool.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.pmtool.model.Proyecto;
import org.pmtool.model.Actividad;
import java.time.LocalDate;

public class GerenteProyectoTest {
    private GerenteProyecto gerente;
    private Proyecto proyecto;

    @BeforeEach
    void setUp() {
        gerente = new GerenteProyecto();
        proyecto = new Proyecto("Proyecto Test", 200, 75000.0);
    }

    @Test
    void testPlanificarProyecto() {
        LocalDate inicio = LocalDate.of(2024, 1, 1);
        LocalDate fin = LocalDate.of(2024, 12, 31);
        
        gerente.planificarProyecto(proyecto, inicio, fin);
        // La planificación no debería lanzar excepción
        
        // Verificar que lanza excepción cuando las fechas están invertidas
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            gerente.planificarProyecto(proyecto, fin, inicio);
        });
    }

    @Test
    void testCrearActividad() {
        Actividad actividad = gerente.crearActividad(proyecto, "1", "Nueva Actividad", 80);
        
        Assertions.assertNotNull(actividad);
        Assertions.assertEquals("1.1", actividad.getNumeroEDT());
        Assertions.assertEquals("Nueva Actividad", actividad.getNombre());
    }

    @Test
    void testPlanificarActividad() {
        Actividad actividad = gerente.crearActividad(proyecto, "1", "Actividad Test", 40);
        LocalDate inicio = LocalDate.of(2024, 2, 1);
        LocalDate fin = LocalDate.of(2024, 3, 31);
        
        gerente.planificarActividad(actividad, inicio, fin);
        // La planificación no debería lanzar excepción
        
        // Verificar que lanza excepción cuando las fechas están invertidas
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            gerente.planificarActividad(actividad, fin, inicio);
        });
    }
} 
