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
    private EstadoProyecto estado;
    private List<Actividad> actividades;

    public enum EstadoProyecto {
        PLANIFICADO,
        EN_CURSO,
        FINALIZADO;
    }

    public Proyecto(String nombre, int totalHorasEstimadas, double presupuesto) {
        this.numero = ++contadorProyectos;
        this.nombre = nombre;
        this.totalHorasEstimadas = totalHorasEstimadas;
        this.presupuesto = presupuesto;
        this.estado = EstadoProyecto.PLANIFICADO;
        this.actividades = new ArrayList<>();
    }

    public void planificarFechas(LocalDate inicio, LocalDate fin) {
        if (inicio.isAfter(fin)) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha de fin.");
        }
        this.fechaInicioPlanificada = inicio;
        this.fechaFinPlanificada = fin;
        this.estado = EstadoProyecto.EN_CURSO;
    }

    public void finalizar(LocalDate fechaFinReal) {
        for (Actividad actividad : actividades) {
            if (!actividad.isCompletada()) {
                throw new IllegalArgumentException("Para finalizar un proyecto todas sus actividades " +
                        "deben estar completadas");
            }
        }

        if (fechaFinReal == null) {
            fechaFinReal = LocalDate.now();
        }

        this.fechaFinReal = fechaFinReal;
        this.estado = EstadoProyecto.FINALIZADO;
    }

    public void agregarActividad(Actividad actividad) {
        actividades.add(actividad);
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaInicioPlanificada() {
        return fechaInicioPlanificada;
    }

    public void setFechaInicioPlanificada(LocalDate fechaInicioPlanificada) {
        this.fechaInicioPlanificada = fechaInicioPlanificada;
    }

    public LocalDate getFechaFinPlanificada() {
        return fechaFinPlanificada;
    }

    public void setFechaFinPlanificada(LocalDate fechaFinPlanificada) {
        this.fechaFinPlanificada = fechaFinPlanificada;
    }

    public LocalDate getFechaInicioReal() {
        return fechaInicioReal;
    }

    public void setFechaInicioReal(LocalDate fechaInicioReal) {
        this.fechaInicioReal = fechaInicioReal;
    }

    public LocalDate getFechaFinReal() {
        return fechaFinReal;
    }

    public void setFechaFinReal(LocalDate fechaFinReal) {
        this.fechaFinReal = fechaFinReal;
    }

    public int getTotalHorasEstimadas() {
        return totalHorasEstimadas;
    }

    public void setTotalHorasEstimadas(int totalHorasEstimadas) {
        this.totalHorasEstimadas = totalHorasEstimadas;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public EstadoProyecto getEstado() {
        return estado;
    }

    public boolean isPlanificado() {
        return EstadoProyecto.PLANIFICADO.equals(this.estado);
    }

    public boolean isEnCurso() {
        return EstadoProyecto.EN_CURSO.equals(this.estado);
    }

    public boolean isFinalizado() {
        return EstadoProyecto.FINALIZADO.equals(this.estado);
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
        private EstadoActividad estado;
        private List<Actividad> subactividades;

        public enum EstadoActividad {
            PLANIFICADA,
            EN_EJECUCION,
            COMPLETADA;
        }

        public Actividad(String numeroEDT, String nombre, int totalHorasEstimadas) {
            this.numeroEDT = numeroEDT;
            this.nombre = nombre;
            this.totalHorasEstimadas = totalHorasEstimadas;
            this.estado = EstadoActividad.PLANIFICADA;
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
            if (EstadoActividad.COMPLETADA.equals(estado)) {
                throw new IllegalStateException("No se puede activar una actividad ya completada.");
            }
            estado = EstadoActividad.EN_EJECUCION;
            fechaInicioReal = LocalDate.now();
        }

        public void desactivar() {
            if (EstadoActividad.PLANIFICADA.equals(estado)) {
                throw new IllegalStateException("No se puede desactivar una actividad que no está en ejecución.");
            }
            estado = EstadoActividad.COMPLETADA;
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

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public LocalDate getFechaInicioPlanificada() {
            return fechaInicioPlanificada;
        }

        public void setFechaInicioPlanificada(LocalDate fechaInicioPlanificada) {
            this.fechaInicioPlanificada = fechaInicioPlanificada;
        }

        public LocalDate getFechaFinPlanificada() {
            return fechaFinPlanificada;
        }

        public void setFechaFinPlanificada(LocalDate fechaFinPlanificada) {
            this.fechaFinPlanificada = fechaFinPlanificada;
        }

        public LocalDate getFechaInicioReal() {
            return fechaInicioReal;
        }

        public void setFechaInicioReal(LocalDate fechaInicioReal) {
            this.fechaInicioReal = fechaInicioReal;
        }

        public LocalDate getFechaFinReal() {
            return fechaFinReal;
        }

        public void setFechaFinReal(LocalDate fechaFinReal) {
            this.fechaFinReal = fechaFinReal;
        }

        public int getTotalHorasEstimadas() {
            return totalHorasEstimadas;
        }

        public void setTotalHorasEstimadas(int totalHorasEstimadas) {
            this.totalHorasEstimadas = totalHorasEstimadas;
        }

        public boolean isCompletada() {
            return EstadoActividad.COMPLETADA.equals(estado);
        }

        public boolean isEnEjecucion() {
            return EstadoActividad.EN_EJECUCION.equals(estado);
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
