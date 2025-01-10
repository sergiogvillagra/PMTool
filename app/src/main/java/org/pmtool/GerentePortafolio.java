package org.pmtool;

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
