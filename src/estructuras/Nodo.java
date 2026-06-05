package estructuras;

import modelo.Ticket;

public class Nodo {
    // Atributos
    private Ticket ticket;
    private Nodo siguiente;

    // Constructor
    public Nodo(Ticket ticket) {
        this.ticket = ticket;
        this.siguiente = null;
    }

    // Getters y Setters
    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}