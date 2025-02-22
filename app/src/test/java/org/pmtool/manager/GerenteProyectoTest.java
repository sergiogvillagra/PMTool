package org.pmtool.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.pmtool.model.Proyecto;
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
        assertThrows(IllegalArgumentException.class, () -> {
            gerente.planificarProyecto(proyecto, fin, inicio);
        });
    }

    @Test
    void testCrearActividad() {
        Proyecto.Actividad actividad = gerente.crearActividad(proyecto, "1", "Nueva Actividad", 80);
        
        assertNotNull(actividad);
        assertEquals("1.1", actividad.getNumeroEDT());
        assertEquals("Nueva Actividad", actividad.toString().split(",")[1].split("'")[1]);
    }

    @Test
    void testPlanificarActividad() {
        Proyecto.Actividad actividad = gerente.crearActividad(proyecto, "1", "Actividad Test", 40);
        LocalDate inicio = LocalDate.of(2024, 2, 1);
        LocalDate fin = LocalDate.of(2024, 3, 31);
        
        gerente.planificarActividad(actividad, inicio, fin);
        // La planificación no debería lanzar excepción
        
        // Verificar que lanza excepción cuando las fechas están invertidas
        assertThrows(IllegalArgumentException.class, () -> {
            gerente.planificarActividad(actividad, fin, inicio);
        });
    }
} 