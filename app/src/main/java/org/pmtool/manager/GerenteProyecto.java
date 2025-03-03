package org.pmtool.manager;

import org.pmtool.model.Proyecto;

import java.time.LocalDate;

public class GerenteProyecto {
    
    public void planificarProyecto(Proyecto proyecto, LocalDate inicio, LocalDate fin) {
        proyecto.planificarFechas(inicio, fin);
    }

    public void finalizarProyecto(Proyecto proyecto, LocalDate fechaFinReal) {
        proyecto.finalizar(fechaFinReal);
    }

    public Proyecto.Actividad crearActividad(Proyecto proyecto, String numeroPadre, String nombre, int horas) {
        String numeroEDT = numeroPadre + "." + (proyecto.getActividades().size() + 1);
        return proyecto.new Actividad(numeroEDT, nombre, horas);
    }

    public void planificarActividad(Proyecto.Actividad actividad, LocalDate inicio, LocalDate fin) {
        actividad.planificarFechas(inicio, fin);
    }
}
