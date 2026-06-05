package estructuras;

import modelo.Ticket;

public class ListaEnlazada {
    // Atributos
    private Nodo primero;

    // Constructor
    public ListaEnlazada() {
        this.primero = null;
    }

    // Getters y Setters
    public Nodo getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }

    // Operaciones
    private boolean estaVacia() {
        return primero == null;
    }

    public void insertarFinal(Ticket ticket) {
        Nodo nodo = new Nodo(ticket);
        if (estaVacia()) {
            this.primero = nodo;
            return;
        }
        Nodo temp = primero;
        while (temp.getSiguiente() != null) {
            temp = temp.getSiguiente();
        }
        temp.setSiguiente(nodo);
    }

    public Ticket buscar(int id) {
        if (estaVacia()) {
            System.out.println("La lista está vacía.\n");
            return null;
        }
        Nodo temp = primero;
        while (temp != null) {
            if (temp.getTicket().getId() == id) {
                return temp.getTicket();
            }
            temp = temp.getSiguiente();
        }
        System.out.println("El ticket no está en la lista.\n");
        return null;
    }

    public void mostrar() {
        if (estaVacia()) {
            System.out.println("La lista está vacía.\n");
            return;
        }
        Nodo temp = primero;
        while (temp != null) {
            System.out.println(temp.getTicket());
            temp = temp.getSiguiente();
        }
    }
}