package org.pmtool.app;

import org.pmtool.model.Proyecto;
import org.pmtool.manager.GerenteProyecto;
import org.pmtool.manager.GerentePortafolio;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        GerentePortafolio gerentePortafolio = new GerentePortafolio();
        GerenteProyecto gerenteProyecto = new GerenteProyecto();

        // Crear un proyecto
        Proyecto proyecto = gerentePortafolio.crearProyecto("Proyecto A", 500, 100000);
        gerenteProyecto.planificarProyecto(proyecto, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 6, 30));

        // Agregar actividades con esquema EDT
        Proyecto.Actividad actividad1 = gerenteProyecto.crearActividad(proyecto, "1", "Actividad Principal", 100);
        gerenteProyecto.planificarActividad(actividad1, LocalDate.of(2024, 1, 15), LocalDate.of(2024, 2, 15));
        proyecto.agregarActividad(actividad1);

        Proyecto.Actividad subActividad1 = gerenteProyecto.crearActividad(
            proyecto, 
            actividad1.getNumeroEDT(), 
            "Subactividad 1", 
            50
        );
        gerenteProyecto.planificarActividad(subActividad1, LocalDate.of(2024, 1, 20), LocalDate.of(2024, 2, 10));
        actividad1.agregarSubactividad(subActividad1);

        Proyecto.Actividad subSubActividad1 = gerenteProyecto.crearActividad(
            proyecto, 
            subActividad1.getNumeroEDT(), 
            "Sub-subactividad 1", 
            25
        );
        gerenteProyecto.planificarActividad(subSubActividad1, LocalDate.of(2024, 1, 22), LocalDate.of(2024, 2, 5));
        subActividad1.agregarSubactividad(subSubActividad1);

        // Mostrar actividades con numeración EDT
        System.out.println(proyecto);
        for (Proyecto.Actividad actividad : proyecto.getActividades()) {
            mostrarActividadConJerarquia(actividad, "");
        }
    }

    private static void mostrarActividadConJerarquia(Proyecto.Actividad actividad, String prefix) {
        System.out.println(prefix + actividad);
        for (Proyecto.Actividad subactividad : actividad.getSubactividades()) {
            mostrarActividadConJerarquia(subactividad, prefix + "  ");
        }
    }
} 
