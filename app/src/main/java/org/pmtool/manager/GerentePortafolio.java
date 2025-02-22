package org.pmtool.manager;

import org.pmtool.model.Proyecto;

import java.util.ArrayList;
import java.util.List;

public class GerentePortafolio {
    private List<Proyecto> proyectos = new ArrayList<>();

    public Proyecto crearProyecto(String nombre, int horas, double presupuesto) {
        Proyecto proyecto = new Proyecto(nombre, horas, presupuesto);
        proyectos.add(proyecto);
        return proyecto;
    }
}