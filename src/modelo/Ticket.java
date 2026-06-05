package modelo;

import java.time.LocalDateTime;

public class Ticket {
    // Atributos
    private static int cantidad = 0;

    private int id;
    private String descripcion;
    private String nombreCompleto;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaResolucion;
    private int prioridad;

    // Constructor
    public Ticket(String descripcion, String nombreCompleto, int prioridad) {
        cantidad++;
        this.id = cantidad;
        this.descripcion = descripcion;
        this.nombreCompleto = nombreCompleto;
        this.fechaCreacion = LocalDateTime.now();
        this.fechaResolucion = null;
        this.prioridad = prioridad;
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(LocalDateTime fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String toString() {
        String fechaTexto;

        if (fechaResolucion != null) {
            fechaTexto = fechaResolucion.toString();
        } else {
            fechaTexto = "Pendiente";
        }

        return "[ID: " + id + "] | Usuario: " + nombreCompleto + " | Prioridad: " + prioridad +
                "\nDescripcion: " + descripcion + "\nCreado: " + fechaCreacion + " | Resuelto: " + fechaTexto + "\n";
    }
}