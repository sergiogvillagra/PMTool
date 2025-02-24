package org.pmtool.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Proyecto {
    private static int contadorProyectos = 1; // Autonumeración de proyectos
    private int numero;
    private String nombre;
    private LocalDate fechaInicioPlanificada;
    private LocalDate fechaFinPlanificada;
    private LocalDate fechaInicioReal;
    private LocalDate fechaFinReal;
    private int totalHorasEstimadas;
    private double presupuesto;
    private String estado;
    private List<Actividad> actividades;

    public Proyecto(String nombre, int totalHorasEstimadas, double presupuesto) {
        this.numero = contadorProyectos++;
        this.nombre = nombre;
        this.totalHorasEstimadas = totalHorasEstimadas;
        this.presupuesto = presupuesto;
        this.estado = "Planificado";
        this.actividades = new ArrayList<>();
    }

    public void planificarFechas(LocalDate inicio, LocalDate fin) {
        if (inicio.isAfter(fin)) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha de fin.");
        }
        this.fechaInicioPlanificada = inicio;
        this.fechaFinPlanificada = fin;
    }

    public void agregarActividad(Actividad actividad) {
        actividades.add(actividad);
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "numero=" + numero +
                ", nombre='" + nombre + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }

    // Clase interna Actividad
    public class Actividad {
        private String numeroEDT;
        private String nombre;
        private LocalDate fechaInicioPlanificada;
        private LocalDate fechaFinPlanificada;
        private LocalDate fechaInicioReal;
        private LocalDate fechaFinReal;
        private int totalHorasEstimadas;
        private String estado;
        private List<Actividad> subactividades;

        public Actividad(String numeroEDT, String nombre, int totalHorasEstimadas) {
            this.numeroEDT = numeroEDT;
            this.nombre = nombre;
            this.totalHorasEstimadas = totalHorasEstimadas;
            this.estado = "Planificada";
            this.subactividades = new ArrayList<>();
        }

        public void planificarFechas(LocalDate inicio, LocalDate fin) {
            if (inicio.isAfter(fin)) {
                throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha de fin.");
            }
            this.fechaInicioPlanificada = inicio;
            this.fechaFinPlanificada = fin;
        }

        public void agregarSubactividad(Actividad subactividad) {
            int subNivel = subactividades.size() + 1;
            subactividad.setNumeroEDT(this.numeroEDT + "." + subNivel);
            subactividades.add(subactividad);
        }

        public void activar() {
            if (estado.equals("Completada")) {
                throw new IllegalStateException("No se puede activar una actividad que ya está completada.");
            }
            estado = "En ejecución";
            fechaInicioReal = LocalDate.now();
        }

        public void desactivar() {
            if (estado.equals("Planificada")) {
                throw new IllegalStateException("No se puede desactivar una actividad que no está en ejecución.");
            }
            estado = "Completada";
            fechaFinReal = LocalDate.now();
        }

        public String getNumeroEDT() {
            return numeroEDT;
        }

        private void setNumeroEDT(String numeroEDT) {
            this.numeroEDT = numeroEDT;
        }

        public List<Actividad> getSubactividades() {
            return subactividades;
        }

        @Override
        public String toString() {
            return "Actividad{" +
                    "numeroEDT='" + numeroEDT + '\'' +
                    ", nombre='" + nombre + '\'' +
                    ", estado='" + estado + '\'' +
                    '}';
        }
    }
}
